package com.kavin.q1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    @Query("SELECT p FROM Person p WHERE p.age =:age")
    List<Person> findPersonAge(@Param("age") int age);
}
