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

    public PaginatedResponse<List<Product>> getAllProducts(Integer page, Integer size) {
        int pageNumber = page != null && page > 0 ? page - 1 : 0;
        int pageSizeValue = size != null && size > 0 ? size : 10;

        Long totalElements = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                .getSingleResult();

        Long totalPages = (totalElements + pageSizeValue - 1) / pageSizeValue;
        Long currentPage = (long) (pageNumber + 1);

        List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class)
                .setFirstResult(pageNumber * pageSizeValue)
                .setMaxResults(pageSizeValue)
                .getResultList();

        Pagination pagination = new Pagination(
                totalElements,
                currentPage,
                (long) pageSizeValue,
                totalPages
        );

        return new PaginatedResponse<>(products, pagination);
    }

    public Product getProductById(Long id) {
        Product product = em.find(Product.class, id);
        if(!em.contains(product)) throw new AppNotFoundException("Product ID " + id + " not found");

        return product;
    }

    public List<Product> getProductByName(String name) {
        String trimmedName = name.trim();
        List<Product> product = em.createQuery("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:name)", Product.class)
                .setParameter("name", "%" + trimmedName + "%")
                .getResultList();

        return product;
    }

    public List<Product> getProductByQuantity(Integer quantity) {
        List<Product> product = em.createQuery("SELECT p FROM Product p WHERE p.quantity < :quantity", Product.class)
                .setParameter("quantity", quantity)
                .getResultList();

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

        return em.merge(product);
    }

    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        if(!em.contains(product)) throw new AppNotFoundException("Product ID " + id + " not found");

        em.remove(product);
    }
}
