package com.test.service;

import com.test.model.Address;  // Import Address class
import com.test.model.Order;
import com.test.repository.OrderRepository;
import com.test.repository.AddressRepository;  // Import AddressRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;  // Inject AddressRepository

    // Create or Update an Order
    public Order saveOrder(Order order, String addressLine, String city, String zipCode) {
        // Step 1: Save the address first
        Address address = new Address();
        address.setAddressLine(addressLine);
        address.setCity(city);
        address.setZipCode(zipCode);
        address = addressRepository.save(address);  // Save address to the database

        // Step 2: Set the addressId in the order
        order.setAddressId(address.getId());  // Link the address to the order

        // Step 3: Save the order with the addressId
        return orderRepository.save(order);
    }

    // Get an Order by ID
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Get all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Delete an Order by ID
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
