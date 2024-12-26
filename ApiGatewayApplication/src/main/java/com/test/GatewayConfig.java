package com.test;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/product/**").uri("lb://ProductServiceApplication"))
                .route(r -> r.path("/inventory/**").uri("lb://InventoryServiceApplication"))
                .route(r -> r.path("/cart/**").uri("lb://CartServiceApplication"))
                .route(r -> r.path("/order/**").uri("lb://OrderServiceApplication"))
                .route(r -> r.path("/customer/**").uri("lb://CustomerServiceApplication"))
                .route(r -> r.path("/auth/**").uri("lb://LoginServiceApplication"))
                
                .build();
    }
}

