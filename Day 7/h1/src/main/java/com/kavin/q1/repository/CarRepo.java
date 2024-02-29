package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Car;
import java.util.List;

public interface CarRepo extends JpaRepository<Car, Integer> {
    List<Car> findByCurrentOwnerNameAndAddress(String currentOwnerName, String address);
}
