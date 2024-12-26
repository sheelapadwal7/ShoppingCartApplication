package com.test.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderss")  // Ensure this matches your actual table name
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID for each new order
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_ids")
    @ElementCollection
    private List<Integer> productIds;  // Store product IDs here (use proper association if needed)

    @Column(name = "total_price")
    private Double totalPrice;
    
    private Long addressId;

    // Constructors, getters, and setters

   

	public Integer getId() {
		return id;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Integer userId, List<Integer> productIds, Double totalPrice, Long addressId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productIds = productIds;
		this.totalPrice = totalPrice;
		this.addressId = addressId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

    
}
