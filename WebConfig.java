package com.unstay.server.config; // Make sure this matches your package structure

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    // 1. Allow the Frontend URL (CORS)
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Apply to all endpoints
                        .allowedOrigins("https://um-stay-client.vercel.app") // ALLOW YOUR FRONTEND
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these actions
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

    // 2. Disable default login (Security)
    // This is required because Spring Security usually blocks the "Preflight" check before CORS can even run.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults()) // Tell Security to use the CORS config above
            .csrf(csrf -> csrf.disable()) // Disable CSRF for Postman/Frontend access
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Allow ALL requests without logging in
            );
        
        return http.build();
    }
}