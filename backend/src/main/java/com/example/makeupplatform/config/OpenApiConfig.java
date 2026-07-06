package com.example.makeupplatform.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI makeupPlatformOpenAPI() {
        return new OpenAPI().info(new Info().title("Makeup Platform API").version("1.0").description("Reservation and product platform"));
    }
}
