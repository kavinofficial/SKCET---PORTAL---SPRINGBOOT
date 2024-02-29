package com.example.c4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.c4.model.Book;

@RestController
public class BookController {
    @Autowired
    public Book bk;

    @GetMapping("/book")
    public Book getBook() {
        return bk;
    }

}
