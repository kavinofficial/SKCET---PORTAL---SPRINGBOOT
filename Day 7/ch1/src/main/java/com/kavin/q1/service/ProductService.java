package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Product;
import com.kavin.q1.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product postPerson(Product p) {
        return productRepo.save(p);
    }

    public List<Product> getPerson() {
        return productRepo.findAll();
    }

    public List<Product> getProductCategory(String productCategory) {
        return productRepo.findByProductCategory(productCategory);
    }

    public List<Product> getPriceCategory(String priceCategory) {
        return productRepo.findByPriceCategory(priceCategory);
    }
}
