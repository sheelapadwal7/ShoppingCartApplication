package com.test.controller;

import com.test.model.Inventory;
import com.test.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Get inventory by product ID
    @CrossOrigin(origins = "http://localhost:8086")
    @GetMapping("/products/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Integer productId) {
        Inventory inventory = inventoryService.getInventoryByProductId(productId);
        if (inventory == null) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
        return ResponseEntity.ok(inventory); // Return 200 with inventory data
    }

    // Update inventory for a product
    @PutMapping("/products/{productId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Integer productId, @RequestParam Integer quantity) {
        Inventory updatedInventory = inventoryService.updateInventory(productId, quantity);
        if (updatedInventory == null) {
            return ResponseEntity.notFound().build(); // Return 404 if inventory not found
        }
        return ResponseEntity.ok(updatedInventory); // Return 200 with updated inventory
    }

    // Reduce inventory when an order is placed
    @CrossOrigin(origins = "http://localhost:8086")
    @PostMapping("/reduce/{productId}")
    public ResponseEntity<String> reduceInventory(@PathVariable Integer productId, @RequestParam Integer quantity) {
        boolean success = inventoryService.reduceInventory(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Inventory reduced successfully");
        }
        return ResponseEntity.badRequest().body("Insufficient inventory or product not found");
    }

    // Add new inventory for a product
    @PostMapping("/add")
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        Inventory addedInventory = inventoryService.addInventory(inventory);
        if (addedInventory == null) {
            return ResponseEntity.badRequest().build(); // Return 400 if inventory could not be added
        }
        return ResponseEntity.ok(addedInventory); // Return 200 with added inventory
    }
}
