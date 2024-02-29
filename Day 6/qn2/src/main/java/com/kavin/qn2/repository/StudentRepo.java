package com.kavin.qn2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.qn2.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
