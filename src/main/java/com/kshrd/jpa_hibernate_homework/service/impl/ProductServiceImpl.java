package com.kshrd.jpa_hibernate_homework.service.impl;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.model.Product;
import com.kshrd.jpa_hibernate_homework.repository.ProductRepository;
import com.kshrd.jpa_hibernate_homework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public PaginatedResponse<List<Product>> getAllProducts(Integer page, Integer size) {
        return productRepository.getAllProducts(page, size);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    @Override
    public List<Product> getProductByQuantity(Integer quantity) {
        return productRepository.getProductByQuantity(quantity);
    }

    @Override
    public Product createProduct(ProductRequest request) {
        return productRepository.createProduct(request);
    }

    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        return productRepository.updateProduct(id, request);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }
}
