package com.ecsite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, String> {

    Product findByProductId(
            String productId);

    List<Product> findByActiveTrue();

    List<Product> findByProductNameContainingAndActiveTrue(String productName);


}