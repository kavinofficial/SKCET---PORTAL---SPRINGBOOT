package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Person;
import com.kavin.q1.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person entity) {
        Person person = personService.postPerson(entity);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getMethod() {
        List<Person> list = personService.getPerson();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/person/byAge")
    public ResponseEntity<List<Person>> getMethodAge(@RequestParam("age") int age) {
        List<Person> list = personService.getPersonByAge(age);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
