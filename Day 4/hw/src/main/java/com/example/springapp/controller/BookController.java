package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springapp.model.Book;
import com.example.springapp.service.BookService;

@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getMethod() {
        List<Book> list = bookService.get();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getId(@PathVariable int id) {
        if (bookService.getById(id) != null) {
            return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("null")
    @PostMapping("")
    public ResponseEntity<Book> post(@RequestBody Book entity) {
        if (bookService.add(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
