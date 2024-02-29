package com.kavin.q1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
    @Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT(:value, '%')")
    List<Person> findByFirstNameStartingWith(@Param("value") String value);

    @Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT('%', :value)")
    List<Person> findByFirstNameEndingWith(@Param("value") String value);
}
