package com.kavin.qn1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.qn1.model.Product;
import com.kavin.qn1.service.ProductService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService childrenService;

    public ProductController(ProductService childrenService) {
        this.childrenService = childrenService;
    }

    @GetMapping("/product/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> getMethodName(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pagesize) {
        List<Product> list = childrenService.pagination(offset, pagesize).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getSort(@PathVariable("productId") int productId) {
        Product list = childrenService.sorting(productId);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> getPageSort(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pagesize,
            @PathVariable("field") String field) {
        List<Product> list = childrenService.pageSort(offset, pagesize, field).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        Product c = childrenService.postPage(entity);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
