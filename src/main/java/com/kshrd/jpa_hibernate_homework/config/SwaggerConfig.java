package com.kshrd.jpa_hibernate_homework.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "JPA / Hibernate Homework",
                version = "1.0.0",
                description = "This Spring Boot application provides CRUD operations for managing products using JPA EntityManager. It supports product creation, updating, deletion, retrieval, and pagination.",
                contact = @Contact(
                        name = "GitHub",
                        url = "https://github.com/HoeunPichet/03_HOEUN_PICHET_JPA_HIBERNATE_HOMEWORK.git"
                )
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Server"),
                @Server(url = "http://localhost:8081", description = "Expose Server"),
        }
)

public class SwaggerConfig {
}
