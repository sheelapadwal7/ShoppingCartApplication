package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.model.Address;  // Import the Address class
import com.test.model.Order;
import com.test.model.ProductDTO;
import com.test.repository.OrderRepository;
import com.test.repository.AddressRepository;  // Import AddressRepository

import java.util.List;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "https://localhost:8086")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;  // Inject AddressRepository

    @Autowired
    private RestTemplate restTemplate;  // Inject RestTemplate

    private static final String PRODUCT_SERVICE_URL = "http://localhost:8080/product/products";  // Adjust this URL as needed

    
	/*
	 * @CrossOrigin(origins = "http://localhost:8086")
	 * 
	 * @RequestMapping(value = "/order/place", method = RequestMethod.OPTIONS)
	 * public ResponseEntity<Void> handleOptions() { return
	 * ResponseEntity.ok().build(); }
	 */

    @CrossOrigin(origins = "http://localhost:8086", methods = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestParam Integer userId, 
                                             @RequestParam List<Integer> productIds, 
                                             @RequestParam String addressLine, 
                                             @RequestParam String city, 
                                             @RequestParam String zipCode) {
        // Log received values for debugging
        System.out.println("Received userId: " + userId);
        System.out.println("Received productIds: " + productIds);
        System.out.println("Received address: " + addressLine + ", " + city + ", " + zipCode);

        if (productIds.isEmpty()) {
            return ResponseEntity.badRequest().body("No products in the cart.");
        }

        // Step 1: Save the address
        Address address = new Address();
        address.setAddressLine(addressLine);
        address.setCity(city);
        address.setZipCode(zipCode);
        address.setUserId(userId);  // Assuming the address is linked to a user
        address = addressRepository.save(address);  // Save the address to the database

        // Step 2: Calculate the total price by calling the product microservice
        double totalPrice = calculateTotalPrice(productIds);

        // Step 3: Create a new Order object
        Order order = new Order();
        order.setUserId(userId);
        order.setProductIds(productIds);  // Directly set productIds as a list
        order.setTotalPrice(totalPrice);
        order.setAddressId(address.getId());  // Link the order to the saved address

        // Step 4: Save the order to the database
        orderRepository.save(order);

        return ResponseEntity.ok("Order placed successfully with address.");
    }

    @CrossOrigin(origins = "http://localhost:8086")
    private double calculateTotalPrice(List<Integer> productIds) {
        double totalPrice = 0.0;

        // Iterate over the productIds and fetch the product data from the product service
        for (Integer productId : productIds) {
            try {
                // Call the product service to fetch product details by ID
                ProductDTO product = restTemplate.getForObject(PRODUCT_SERVICE_URL + "/" + productId, ProductDTO.class);

                // If the product is found, add its price to the total price
                if (product != null) {
                    totalPrice += product.getPrice();
                } else {
                    System.out.println("Product with ID " + productId + " not found.");
                }
            } catch (Exception e) {
                System.out.println("Error fetching product with ID " + productId + ": " + e.getMessage());
            }
        }

        return totalPrice;
    }
}
