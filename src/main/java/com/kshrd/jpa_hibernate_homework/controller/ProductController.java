package com.kshrd.jpa_hibernate_homework.controller;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.ApiResponse;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.model.Product;
import com.kshrd.jpa_hibernate_homework.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(
        summary = "Get all products {paginated}",
        description = "Returns a paginated list of all products. Accepts page and size as query parameters."
    )
    public ResponseEntity<ApiResponse<PaginatedResponse<List<Product>>>> getAllProducts(
        @Parameter(description = "Page number (starting from 1)", required = true)
        @RequestParam(defaultValue = "1") @Valid @Min(value = 1, message = "Page must be greater than 0") Integer page,

        @Parameter(description = "Number of items per page", required = true)
        @RequestParam(defaultValue = "10") @Valid @Min(value = 1, message = "Size must be greater than 0") Integer size
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
    @Operation(
        summary = "Get product by id",
        description = "Fetches a product using its unique ID. Returns 404 if not found."
    )
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
    @Operation(
        summary = "Get all products by name",
        description = "Returns a list of products that contain the given name (case-insensitive partial match)."
    )
    public ResponseEntity<ApiResponse<List<Product>>> getProductByName(@RequestParam String name) {
        List<Product> product = productService.getProductByName(name);
        ApiResponse<List<Product>> response = ApiResponse.<List<Product>>builder()
                .success(true)
                .message("Products matching name '" + name + "' fetched successfully")
                .status(HttpStatus.OK)
                .payload(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/low-stock")
    @Operation(
        summary = "Get low stock products",
        description = "Returns a list of products with quantity less than the specified threshold."
    )
    public ResponseEntity<ApiResponse<List<Product>>> getProductByQuantity(@RequestParam Integer quantity) {
        List<Product> product = productService.getProductByQuantity(quantity);
        ApiResponse<List<Product>> response = ApiResponse.<List<Product>>builder()
                .success(true)
                .message("Products with quantity less than " + quantity + " fetched successfully")
                .status(HttpStatus.OK)
                .payload(product)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(
        summary = "Create a new product",
        description = "Accepts a product request payload and creates a new product. Returns the created product."
    )
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
    @Operation(
        summary = "Update product by id",
        description = "Updates an existing product with the given ID using the request body. Returns the updated product."
    )
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequest request) {
        Product product = productService.updateProduct(id, request);
        ApiResponse<Product> response = ApiResponse.<Product>builder()
            .success(true)
            .message("Product with ID " + id + " updated successfully!")
            .status(HttpStatus.OK)
            .payload(product)
            .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete product by id",
        description = "Deletes a product by its ID. Returns HTTP 200 if the product is successfully deleted."
    )
    public ResponseEntity<ApiResponse<Product>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        ApiResponse<Product> response = ApiResponse.<Product>builder()
            .success(true)
            .message("Product with ID " + id + " deleted successfully!")
            .status(HttpStatus.OK)
            .build();

        return ResponseEntity.ok(response);
    }

}
