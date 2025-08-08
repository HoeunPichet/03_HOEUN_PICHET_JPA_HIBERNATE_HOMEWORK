package com.kshrd.jpa_hibernate_homework.repository;

import com.kshrd.jpa_hibernate_homework.dto.request.ProductRequest;
import com.kshrd.jpa_hibernate_homework.dto.response.PaginatedResponse;
import com.kshrd.jpa_hibernate_homework.exception.AppNotFoundException;
import com.kshrd.jpa_hibernate_homework.model.Pagination;
import com.kshrd.jpa_hibernate_homework.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class ProductRepository {
    @PersistenceContext
    private final EntityManager em;

    public PaginatedResponse<List<Product>> getAllProducts(Long page, Long size) {
        int pageNumber = page != null && page > 0 ? Math.toIntExact(page - 1) : 0;
        int pageSize = size != null && size > 0 ? Math.toIntExact(size) : 10;

        // Count total records
        Long totalElements = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
            .getSingleResult();

        // Calculate total pages
        Long totalPages = (totalElements + pageSize - 1) / pageSize;
        Long currentPage = ((long) pageNumber) + 1;

        // Fetch paginated data
        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class)
            .setFirstResult(pageNumber * pageSize)
            .setMaxResults(pageSize)
            .getResultList();

        // Build pagination info
        Pagination pagination = new Pagination(
            totalElements,
            currentPage,
            (long) pageSize,
            totalPages
        );

        return new PaginatedResponse<>(products, pagination);
    }

    public Product getProductById(Long id) {
        Product product = em.find(Product.class, id);
        if(!em.contains(product)) throw new AppNotFoundException("Product ID " + id + " not found");

        return product;
    }

    public Product createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        em.persist(product);

        return product;
    }

    public Product updateProduct(Long id, ProductRequest request) {
        Product product = em.find(Product.class, id);
        if(!em.contains(product)) throw new AppNotFoundException("Product ID " + id + " not found");
        em.detach(product);

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        em.merge(product);

        return product;
    }
}
