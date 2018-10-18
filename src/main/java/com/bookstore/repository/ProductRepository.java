package com.bookstore.repository;

import com.bookstore.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId, Pageable pageable);

    Long countByCategoryId(Long categoryId);
}
