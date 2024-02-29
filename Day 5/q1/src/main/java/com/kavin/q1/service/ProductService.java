package com.kavin.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Product;
import com.kavin.q1.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product post(Product p) {
        return productRepo.save(p);
    }

    public Product put(int id, Product p) {
        Product newProduct = productRepo.findById(id).orElse(null);
        newProduct.setProductId(id);
        newProduct.setProductName(p.getProductName());
        newProduct.setProductDescription(p.getProductDescription());
        return productRepo.save(newProduct);
    }

    public Product del(int id) {
        Product p = productRepo.findById(id).orElse(null);
        if (p != null) {
            productRepo.deleteById(id);
            return p;
        }
        return null;
    }
}
