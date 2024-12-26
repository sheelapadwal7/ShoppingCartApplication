
package com.test.controller;
import com.test.model.Cart;
import com.test.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    
    @CrossOrigin(origins = "http://localhost:8086")
    @PostMapping("/add")
    public String addToCart(@RequestParam Integer userId, @RequestParam Integer productId, @RequestParam int quantity) {
        Cart cart = new Cart(userId, productId, quantity);
        cartRepository.save(cart);
        return "Product added to cart";
    }

   
    
    @CrossOrigin(origins = "http://localhost:8086")
    @GetMapping("/view")
    public List<Cart> getCart(@RequestParam Integer userId) {
        return cartRepository.findAll().stream()
            .filter(cart -> cart.getUserId().equals(userId))
            .collect(Collectors.toList());
    }
}
