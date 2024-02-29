package com.kavin.q4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kavin.q4.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
