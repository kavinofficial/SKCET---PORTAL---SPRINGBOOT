package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.Repository.PersonRepo;
import com.kavin.q1.model.Person;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Person post(Person p) {
        return personRepo.save(p);
    }

    public List<Person> get(int age) {
        return personRepo.findPersonAge(age);
    }
}
