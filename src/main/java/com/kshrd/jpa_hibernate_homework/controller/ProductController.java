package com.kshrd.jpa_hibernate_homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
@Tag(name = "Product")
public class ProductController {

    @GetMapping
    @Operation(summary = "Get all products")
    public ResponseEntity<String> getAllProducts() {
        return null;
    }

    @GetMapping("/{product-id}")
    @Operation(summary = "Get product by id")
    public ResponseEntity<String> getProductById(@PathVariable("product-id") Long id) {
        return null;
    }

    @GetMapping("/{name}")
    @Operation(summary = "Get all products by name")
    public ResponseEntity<String> getProductByName(@PathVariable("name") String name) {
        return null;
    }

    @GetMapping("/{quantity}")
    @Operation(summary = "Get product by quantity")
    public ResponseEntity<String> getProductByQuantity(@PathVariable("quantity") Long quantity) {
        return null;
    }

    @PostMapping
    @Operation(summary = "Create a product")
    public ResponseEntity<String> createProduct() {
        return null;
    }

    @PutMapping("/{product-id}")
    @Operation(summary = "Update product by id")
    public ResponseEntity<String> updateProduct(@PathVariable("product-id") Long id) {
        return null;
    }

    @DeleteMapping("/{product-id}")
    @Operation(summary = "Delete product by id")
    public ResponseEntity<String> deleteProduct(@PathVariable("product-id") Long id) {
        return null;
    }

}
