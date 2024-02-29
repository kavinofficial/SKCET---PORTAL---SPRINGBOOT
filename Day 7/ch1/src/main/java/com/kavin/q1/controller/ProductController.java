package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Product;
import com.kavin.q1.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        Product person = productService.postPerson(entity);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getMethod() {
        List<Product> list = productService.getPerson();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/category/{productCategory}")
    public ResponseEntity<List<Product>> getMethodProduct(@PathVariable("productCategory") String productCategory) {
        List<Product> list = productService.getProductCategory(productCategory);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/pricecategory/{priceCategory}")
    public ResponseEntity<List<Product>> getMethodPrice(@PathVariable("priceCategory") String priceCategory) {
        List<Product> list = productService.getPriceCategory(priceCategory);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}