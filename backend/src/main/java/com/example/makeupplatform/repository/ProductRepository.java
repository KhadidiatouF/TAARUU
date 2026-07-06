package com.example.makeupplatform.repository;

import com.example.makeupplatform.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Product> findByCategoryIgnoreCase(String category, Pageable pageable);
    Page<Product> findByCategoryIgnoreCaseAndNameContainingIgnoreCase(String category, String keyword, Pageable pageable);
}
