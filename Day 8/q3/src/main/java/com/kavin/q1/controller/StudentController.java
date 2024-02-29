package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Student;
import com.kavin.q1.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> getMethodName(@RequestBody Student param) {
        Student p = studentService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/student/marksGreaterThan/{mark}")
    public ResponseEntity<List<Student>> getGreater(@PathVariable("mark") int mark) {
        List<Student> list = studentService.getGreater(mark);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/student/marksLesserThan/{mark}")
    public ResponseEntity<List<Student>> getLesser(@PathVariable("mark") int mark) {
        List<Student> list = studentService.getLesser(mark);
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
