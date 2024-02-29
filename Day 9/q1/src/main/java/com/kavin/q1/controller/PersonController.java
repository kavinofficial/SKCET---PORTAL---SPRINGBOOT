package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Person;
import com.kavin.q1.service.PersonService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> getMethodName(@RequestBody Person param) {
        Person p = personService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/person/byage/{age}")
    public ResponseEntity<List<Person>> getMethodName(@PathVariable("age") int age) {
        List<Person> list = personService.get(age);
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
