package com.kshrd.jpa_hibernate_homework.service;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.model.Product;
import jakarta.validation.Valid;

import java.util.ArrayList;

public interface ProductService {

    ArrayList<Product> getAllProducts(Long page, Long size);

    Product getProductById(Long id);

    ArrayList<Product> getProductByName(String name);

    ArrayList<Product> getProductByQuantity(Long quantity);

    Product createProduct(@Valid ProductRequest request);

    Product updateProduct(Long id, @Valid ProductRequest request);

    void deleteProduct(Long id);
}
