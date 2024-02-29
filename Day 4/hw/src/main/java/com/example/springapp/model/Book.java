package com.example.springapp.model;

import jakarta.persistence.Entity;

@Entity
public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private int price;

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }
}