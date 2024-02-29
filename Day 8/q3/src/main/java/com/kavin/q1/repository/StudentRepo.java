package com.kavin.q1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.marks >:mark")
    List<Student> marksGreaterThan(@Param("mark") int mark);

    @Query("SELECT s FROM Student s WHERE s.marks <:mark")
    List<Student> marksLesserThan(@Param("mark") int mark);
}
