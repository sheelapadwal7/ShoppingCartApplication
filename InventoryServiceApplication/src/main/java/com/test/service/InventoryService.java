package com.test.service;

import com.test.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.repository.InventoryRepository; // Assuming you're using JPA repository

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    
    public Inventory getInventoryByProductId(Integer productId) {
        return inventoryRepository.findByProductId(productId); 
    }

    
    public Inventory updateInventory(Integer productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null) {
            return null; 
        }
        inventory.setQuantity(quantity); 
        return inventoryRepository.save(inventory); 
    }

    
    public boolean reduceInventory(Integer productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory == null || inventory.getQuantity() < quantity) {
            return false;
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory); 
        return true;
    }

    
    public Inventory addInventory(Inventory inventory) {
        
        Inventory existingInventory = inventoryRepository.findByProductId(inventory.getProductId());
        if (existingInventory != null) {
            return null; 
        }
        return inventoryRepository.save(inventory); // Save new inventory
    }
}
