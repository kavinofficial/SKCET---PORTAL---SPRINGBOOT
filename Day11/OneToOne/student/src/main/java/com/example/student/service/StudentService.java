package com.example.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.model.StudentInfo;
import com.example.student.repository.StudentInfoRepo;
import com.example.student.repository.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentInfoRepo studentInfoRepo;
    
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepo.save(studentInfo);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public List<StudentInfo> getStudentInfo() {
        return studentInfoRepo.findAll();
    }
}
