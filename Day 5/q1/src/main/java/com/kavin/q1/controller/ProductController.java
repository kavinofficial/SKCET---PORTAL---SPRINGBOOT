package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Product;
import com.kavin.q1.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product getMethodName(@RequestBody Product entity) {
        return productService.post(entity);
    }

    @PutMapping("/product/{productId}")
    public Product putMethodName(@PathVariable int productId, @RequestBody Product entity) {
        return productService.put(productId, entity);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
        Product deletedProduct = productService.del(id);
        if (deletedProduct != null) {
            return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
