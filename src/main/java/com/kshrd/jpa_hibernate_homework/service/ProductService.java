package com.kshrd.jpa_hibernate_homework.service;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.model.Product;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    PaginatedResponse<List<Product>> getAllProducts(Long page, Long size);

    Product getProductById(Long id);

    List<Product> getProductByName(String name);

    List<Product> getProductByQuantity(Integer quantity);

    Product createProduct(@Valid ProductRequest request);

    Product updateProduct(Long id, @Valid ProductRequest request);

    void deleteProduct(Long id);
}
