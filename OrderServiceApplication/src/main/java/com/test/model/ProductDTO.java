package com.test.model;

public class ProductDTO {
 private Integer id;
 private String name;
 private Double price;

 // Constructor
 public ProductDTO() {}

 // Getters and Setters
 public Integer getId() {
     return id;
 }

 public void setId(Integer id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public Double getPrice() {
     return price;
 }

 public void setPrice(Double price) {
     this.price = price;
 }
}

