package com.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.model.Product;
import com.test.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:8086") 
public class ProductController {

    @Autowired
    private ProductService productService;


    // Get a product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        // In your productService, you should set image URLs for each product
        return productService.getAllProducts();
    }

    // Add a new product (including image URL)
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        // Make sure imageUrl is set correctly
        return productService.addProduct(product);
    }

    // Update a product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    // Delete a product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
    	productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

