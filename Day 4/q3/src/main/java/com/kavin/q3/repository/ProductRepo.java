package com.kavin.q3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q3.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
