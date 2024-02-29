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

    public Person postPerson(Person p) {
        return personRepo.save(p);
    }

    public List<Person> getPerson() {
        return personRepo.findAll();
    }

    public List<Person> getPersonByAge(int age) {
        return personRepo.findByAge(age);
    }
}
