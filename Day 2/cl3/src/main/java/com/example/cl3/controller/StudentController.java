package com.example.cl3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.cl3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {
    @Autowired
    public Student st;

    @GetMapping("/student")
    public Student getMethodName() {

        return st;
    }

}
