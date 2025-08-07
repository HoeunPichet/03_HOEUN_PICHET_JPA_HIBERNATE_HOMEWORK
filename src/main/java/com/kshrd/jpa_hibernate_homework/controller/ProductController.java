package com.kshrd.jpa_hibernate_homework.controller;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Tag(name = "Product")
public class ProductController {

    @GetMapping
    @Operation(summary = "Get all products {paginated}")
    public ResponseEntity<String> getAllProducts() {
        return null;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id")
    public ResponseEntity<String> getProductById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/search")
    @Operation(summary = "Get all products by name")
    public ResponseEntity<String> getProductByName(@RequestParam String name) {
        return null;
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Get low stock products")
    public ResponseEntity<String> getProductByQuantity(@RequestParam Long quantity) {
        return null;
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request) {
        return null;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product by id")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by id")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return null;
    }

}
