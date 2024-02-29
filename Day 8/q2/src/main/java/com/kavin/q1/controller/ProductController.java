package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Product;
import com.kavin.q1.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> getMethodName(@RequestBody Product param) {
        Product p = productService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/distinct/endWith/{name}")
    public ResponseEntity<List<Product>> getEndsWith(@PathVariable("name") String name) {
        List<Product> list = productService.getEnd(name);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/distinct/startWith/{name}")
    public ResponseEntity<List<Product>> getStartsWith(@PathVariable("name") String name) {
        List<Product> list = productService.getStart(name);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/sortBy/price")
    public ResponseEntity<List<Product>> sort() {
        List<Product> list = productService.sortPrice();
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
