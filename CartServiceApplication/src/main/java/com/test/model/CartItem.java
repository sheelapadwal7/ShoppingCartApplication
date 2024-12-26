package com.test.model;

import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;  // This is where the product ID resides
    private Integer quantity;

    // Getters and Setters
   

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
