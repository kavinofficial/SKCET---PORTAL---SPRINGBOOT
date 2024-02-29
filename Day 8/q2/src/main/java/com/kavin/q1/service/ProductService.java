package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Product;
import com.kavin.q1.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo personRepo;

    public Product post(Product p) {
        return personRepo.save(p);
    }

    public List<Product> getStart(String value) {
        return personRepo.findByFirstName(value);
    }

    public List<Product> getEnd(String value) {
        return personRepo.findByLastName(value);
    }

    public List<Product> sortPrice() {
        return personRepo.sortByPrice();
    }
}
