package com.kavin.q3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kavin.q3.model.Product;
import com.kavin.q3.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public boolean postProduct(Product p) {
        try {
            productRepo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductId(int id) {
        return productRepo.findById(id);
    }
}
