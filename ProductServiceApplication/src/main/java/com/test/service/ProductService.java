package com.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Product;
import com.test.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Fetch all products from the catalog
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a specific product by ID
    public Product getProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(Integer productId, Product product) {
        if (productRepository.existsById(productId)) {
            product.setId(productId);
            return productRepository.save(product);
        }
        return null;
    }

    // Delete a product
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}

