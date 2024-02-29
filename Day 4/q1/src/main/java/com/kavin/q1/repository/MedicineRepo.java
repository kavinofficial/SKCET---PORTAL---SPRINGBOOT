package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kavin.q1.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer> {

}
