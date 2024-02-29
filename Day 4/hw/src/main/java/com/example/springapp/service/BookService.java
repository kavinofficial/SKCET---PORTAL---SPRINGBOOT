package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Book;
import com.example.springapp.repository.BookRepo;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> get() {
        return bookRepo.findAll();
    }

    public Book getById(int id) {
        try {
            @SuppressWarnings("deprecation")
            Book b = bookRepo.getById(id);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("null")
    public boolean add(Book p) {
        try {
            bookRepo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
