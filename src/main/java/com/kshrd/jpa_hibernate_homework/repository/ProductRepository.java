package com.kshrd.jpa_hibernate_homework.repository;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class ProductRepository {
    @PersistenceContext
    private final EntityManager em;

    @Transactional
    Product createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        em.persist(product);

        return product;
    }
}
