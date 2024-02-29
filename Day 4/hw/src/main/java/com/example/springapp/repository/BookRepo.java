package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
