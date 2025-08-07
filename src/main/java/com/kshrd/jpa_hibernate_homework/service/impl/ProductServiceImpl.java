package com.kshrd.jpa_hibernate_homework.service.impl;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.model.Product;
import com.kshrd.jpa_hibernate_homework.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ArrayList<Product> getAllProducts(Long page, Long size) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public ArrayList<Product> getProductByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Product> getProductByQuantity(Long quantity) {
        return null;
    }

    @Override
    public Product createProduct(ProductRequest request) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
