package com.kavin.qn2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kavin.qn2.model.Student;
import com.kavin.qn2.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Page<Student> pagination(int offset, int size) {
        return studentRepo
                .findAll(PageRequest.of(offset, size));
    }

    public List<Student> sorting(String field) {
        return studentRepo.findAll(Sort.by(Direction.ASC, field));
    }

    public Page<Student> pageSort(int offset, int pagesize, String field) {
        return studentRepo.findAll(PageRequest.of(offset, pagesize, Sort.by(Direction.ASC, field)));
    }

    public Student postPage(Student l) {
        return studentRepo.save(l);
    }
}
