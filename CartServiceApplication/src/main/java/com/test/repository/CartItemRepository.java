package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteById(Long cartItemId); // Delete cart item by ID
}
