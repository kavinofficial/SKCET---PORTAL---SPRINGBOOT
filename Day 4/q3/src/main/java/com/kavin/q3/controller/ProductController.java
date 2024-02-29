package com.kavin.q3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q3.model.Product;
import com.kavin.q3.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        if (productService.postProduct(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> list = productService.getProducts();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{param}")
    public ResponseEntity<Optional<Product>> getMethodName(@PathVariable int param) {
        Optional<Product> prod = productService.getProductId(param);
        if (prod.isPresent()) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }
        return new ResponseEntity<>(prod, HttpStatus.NOT_FOUND);
    }

}
