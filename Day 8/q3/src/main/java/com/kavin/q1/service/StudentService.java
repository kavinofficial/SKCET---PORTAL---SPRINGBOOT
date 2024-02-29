package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Student;
import com.kavin.q1.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student post(Student p) {
        return studentRepo.save(p);
    }

    public List<Student> getGreater(int value) {
        return studentRepo.marksGreaterThan(value);
    }

    public List<Student> getLesser(int value) {
        return studentRepo.marksLesserThan(value);
    }
}
