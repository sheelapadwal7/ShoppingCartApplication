package com.test.service;

import com.test.model.Cart;
import com.test.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Method to add a product to the cart
    public String addToCart(Integer userId, Integer productId, int quantity) {
        // Create a new Cart object
        Cart cart = new Cart(userId, productId, quantity);
        
        // Save the cart to the database
        cartRepository.save(cart);
        
        return "Product added to cart successfully";
    }
}
