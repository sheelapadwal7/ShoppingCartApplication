package com.test.model;

import java.util.List;

public class CartRequest {
    private Integer userId;
    private List<ProductQuantity> products;

    

    public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public List<ProductQuantity> getProducts() {
		return products;
	}



	public void setProducts(List<ProductQuantity> products) {
		this.products = products;
	}



	public static class ProductQuantity {
        private Integer productId;
        private int quantity;
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

        
    }
}

