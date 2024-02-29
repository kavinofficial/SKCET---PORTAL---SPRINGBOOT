package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Product;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByProductCategory(String productCategory);

    List<Product> findByPriceCategory(String priceCategory);
}
