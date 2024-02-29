package com.kavin.qn1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kavin.qn1.model.Product;
import com.kavin.qn1.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Page<Product> pagination(int offset, int size) {
        return productRepo
                .findAll(PageRequest.of(offset, size));
    }

    public Product sorting(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Page<Product> pageSort(int offset, int pagesize, String field) {
        return productRepo.findAll(PageRequest.of(offset, pagesize, Sort.by(Direction.ASC, field)));
    }

    public Product postPage(Product l) {
        return productRepo.save(l);
    }
}
