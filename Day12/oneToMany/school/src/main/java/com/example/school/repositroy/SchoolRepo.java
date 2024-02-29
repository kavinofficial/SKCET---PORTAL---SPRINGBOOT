package com.example.school.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.model.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Integer> {
    
}
