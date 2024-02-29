package com.kavin.q1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT DISTINCT p FROM Product p WHERE p.productName LIKE CONCAT(:name, '%')")
    List<Product> findByFirstName(@Param("name") String name);

    @Query("SELECT DISTINCT p FROM Product p WHERE p.productName LIKE CONCAT('%' , :name)")
    List<Product> findByLastName(@Param("name") String name);

    @Query("SELECT p FROM Product p ORDER BY price ASC")
    List<Product> sortByPrice();
}
