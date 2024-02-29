package com.kavin.hw.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.hw.config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiController {
    @Autowired
    public AppConfig ap;

    @GetMapping("/")
    public String getMethodName() {
        return "Student Name:" + ap.getStudentName() + ",Department:" + ap.getStudentDepartment();
    }

}
