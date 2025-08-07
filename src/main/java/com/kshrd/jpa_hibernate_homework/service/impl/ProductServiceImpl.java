package com.kshrd.jpa_hibernate_homework.service.impl;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.model.Product;
import com.kshrd.jpa_hibernate_homework.repository.ProductRepository;
import com.kshrd.jpa_hibernate_homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public PaginatedResponse<List<Product>> getAllProducts(Long page, Long size) {
        return productRepository.getAllProducts(page, size);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductByQuantity(Long quantity) {
        return null;
    }

    @Override
    public Product createProduct(ProductRequest request) {
        return productRepository.createProduct(request);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
