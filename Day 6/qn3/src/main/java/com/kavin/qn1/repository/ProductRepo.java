package com.kavin.qn1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.qn1.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
