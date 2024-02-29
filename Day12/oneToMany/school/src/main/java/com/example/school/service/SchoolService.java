package com.example.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.model.School;
import com.example.school.model.Student;
import com.example.school.repositroy.SchoolRepo;
import com.example.school.repositroy.StudentRepo;

@Service
public class SchoolService {
    
    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private StudentRepo studentRepo;

    public School saveSchool(School school) {
        return schoolRepo.save(school);
    }

    public Student saveStudent(Student student)
    {
        return studentRepo.save(student);
    }

    public School getSchool(int id) {
        return schoolRepo.findById(id).orElse(null);
    }

    public Student getStudent(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<School> getSchools(){
        return schoolRepo.findAll();
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
}
