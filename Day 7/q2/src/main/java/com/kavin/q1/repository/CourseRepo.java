package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Course;
import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer> {
    List<Course> findByCourseName(String courseName);
}
