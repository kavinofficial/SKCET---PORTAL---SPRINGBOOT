package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Person;
import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<Person> findByAge(int age);
}
