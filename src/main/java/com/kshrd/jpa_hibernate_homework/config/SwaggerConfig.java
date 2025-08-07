package com.kshrd.jpa_hibernate_homework.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "JPA/Hibernate",
                version = "1.0.0",
                description = "API documentation for the JPA/Hibernate homework"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
        }
)

public class SwaggerConfig {
}
