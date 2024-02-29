package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Car;
import com.kavin.q1.repository.CarRepo;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public Car postPerson(Car p) {
        return carRepo.save(p);
    }

    public List<Car> getCar() {
        return carRepo.findAll();
    }

    public List<Car> getOwnerAdress(String name, String address) {
        return carRepo.findByCurrentOwnerNameAndAddress(name, address);
    }
}
