package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Course;
import com.kavin.q1.repository.CourseRepo;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Course postPerson(Course p) {
        return courseRepo.save(p);
    }

    public List<Course> getPerson() {
        return courseRepo.findAll();
    }

    public List<Course> getPersonByAge(String courseName) {
        return courseRepo.findByCourseName(courseName);
    }
}
