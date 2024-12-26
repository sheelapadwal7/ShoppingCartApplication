/*
 * package com.test; import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.web.reactive.config.CorsRegistry;
 * 
 * 
 * @Configuration public class WebConfig {
 * 
 * public void addCorsMappings(CorsRegistry registry) { // Allow CORS requests
 * from the frontend (localhost:8086) registry.addMapping("/**") // Apply to all
 * endpoints .allowedOrigins("http://localhost:8086") // The frontend URL
 * .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
 * .allowedHeaders("*") // Allow any headers .allowCredentials(true); // Allow
 * cookies (if needed) } }
 * 
 */