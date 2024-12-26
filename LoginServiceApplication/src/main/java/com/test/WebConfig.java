package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class WebConfig  {

    public void addCorsMappings(CorsRegistry registry) {
        // Allow all paths for CORS requests from the frontend on port 8086
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8086")  // Allow only requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials (cookies, headers, etc.)
    }
}
