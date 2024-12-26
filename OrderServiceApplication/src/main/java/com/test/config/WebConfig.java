package com.test.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig {

    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;

    @Value("${cors.allowedMethods}")
    private String allowedMethods;

    @Value("${cors.allowedHeaders}")
    private String allowedHeaders;

    @Value("${cors.exposedHeaders}")
    private String exposedHeaders;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        
        // Configure CORS based on properties from application.properties
        config.addAllowedOrigin(allowedOrigins);  // Allowed Origins
        config.setAllowedMethods(Arrays.asList(allowedMethods.split(",")));  // Allowed Methods
        config.setAllowedHeaders(Arrays.asList(allowedHeaders.split(",")));  // Allowed Headers
        config.setExposedHeaders(Arrays.asList(exposedHeaders.split(",")));  // Exposed Headers (optional)

        // Register the CORS configuration to all paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}

