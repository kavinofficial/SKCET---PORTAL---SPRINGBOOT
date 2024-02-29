package com.example.cl3.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class Student {
    @JsonIgnore
    @Value("${student.id}")
    private long id;
    @Value("${student.name}")
    private String name;
    @Value("${student.description}")
    private String description;

    public Student() {
    }

    public Student(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
