package com.example.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.model.School;
import com.example.school.model.Student;
import com.example.school.service.SchoolService;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;
    
    @PostMapping("/school")
    public School saveSchool(@RequestBody School school)
    {
        return schoolService.saveSchool(school);
    }

    @PostMapping("/student")
    public Student savStudent(@RequestBody Student student)
    {
        return schoolService.saveStudent(student);
    }

    @GetMapping("/schools")
    public List<School> getSchools()
    {
        return schoolService.getSchools();
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return schoolService.getStudents();
    }

    @GetMapping("/school/{id}")
    public School getSchool(@PathVariable int id)
    {
        return schoolService.getSchool(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return schoolService.getStudent(id);
    }
}