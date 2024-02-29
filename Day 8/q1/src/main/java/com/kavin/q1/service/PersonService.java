package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Person;
import com.kavin.q1.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Person post(Person p) {
        return personRepo.save(p);
    }

    public List<Person> getStart(String value) {
        return personRepo.findByFirstNameStartingWith(value);
    }

    public List<Person> getEnd(String value) {
        return personRepo.findByFirstNameEndingWith(value);
    }
}
