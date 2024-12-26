package com.test.repository;

import com.test.model.Cart;
import com.test.model.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	//List<Cart> getCartItemsForUser(Long userId);
    
    // Find the cart by customerId
	/*
	 * Cart findByCustomerId(Integer customerId);
	 * 
	 * // Optionally, you can also query Cart by customerId and productId (for
	 * specific cart item queries) Optional<CartItem>
	 * findByCustomerIdAndItemsProductId(Integer customerId, Integer productId);
	 */
}
