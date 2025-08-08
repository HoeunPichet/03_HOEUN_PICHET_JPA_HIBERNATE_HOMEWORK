package com.kshrd.jpa_hibernate_homework.controller;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.ApiResponse;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.model.Product;
import com.kshrd.jpa_hibernate_homework.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "Get all products {paginated}")
    public ResponseEntity<ApiResponse<PaginatedResponse<List<Product>>>> getAllProducts(
        @RequestParam(defaultValue = "1") @Min(value = 1, message = "Offset must be greater than 0") Long page,
        @RequestParam(defaultValue = "10") @Min(value = 1, message = "Limit must be greater than 0") Long size
    ) {
        PaginatedResponse<List<Product>> product = productService.getAllProducts(page, size);
        ApiResponse<PaginatedResponse<List<Product>>> response = ApiResponse.<PaginatedResponse<List<Product>>>builder()
                .success(true)
                .message("Get all products successfully!")
                .status(HttpStatus.OK)
                .payload(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by id")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ApiResponse<Product> response = ApiResponse.<Product>builder()
                .success(true)
                .message("Get product with ID " + id)
                .status(HttpStatus.OK)
                .payload(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    @Operation(summary = "Get all products by name")
    public ResponseEntity<String> getProductByName(@RequestParam String name) {
        return null;
    }

    @GetMapping("/low-stock")
    @Operation(summary = "Get low stock products")
    public ResponseEntity<String> getProductByQuantity(@RequestParam Integer quantity) {
        return null;
    }

    @PostMapping
    @Operation(summary = "Create a new product")
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody @Valid ProductRequest request) {
        Product product = productService.createProduct(request);
        ApiResponse<Product> response = ApiResponse.<Product>builder()
                .success(true)
                .message("Product created successfully!")
                .status(HttpStatus.CREATED)
                .payload(product)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
