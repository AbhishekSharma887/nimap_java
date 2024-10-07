package com.javaenginner.repository;
import com.javaenginner.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Category, Long> {
    // You can add custom query methods here if needed
}

