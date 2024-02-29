package com.kavin.qn2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.qn2.model.Student;
import com.kavin.qn2.service.StudentService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService childrenService) {
        this.studentService = childrenService;
    }

    @GetMapping("/student/offset/pagesize")
    public ResponseEntity<List<Student>> getMethodName(@RequestParam("offset") int offset,
            @RequestParam("pagesize") int pagesize) {
        List<Student> list = studentService.pagination(offset, pagesize).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/children/sort/offset/pagesize/field")
    public ResponseEntity<List<Student>> getPageSort(@RequestParam("offset") int offset,
            @RequestParam("pagesize") int pagesize,
            @RequestParam("field") String field) {
        List<Student> list = studentService.pageSort(offset, pagesize, field).toList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PostMapping("/student")
    public ResponseEntity<Student> postMethodName(@RequestBody Student entity) {
        Student c = studentService.postPage(entity);
        if (c != null) {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
