package com.kavin.q1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Car;
import com.kavin.q1.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/car")
    public ResponseEntity<Car> postMethodName(@RequestBody Car entity) {
        Car person = carService.postPerson(entity);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getMethod() {
        List<Car> list = carService.getCar();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/car/distinct")
    public ResponseEntity<List<Car>> getMethodAccess(@RequestParam("currentOwnerName") String currentOwnerName,
            @RequestParam("address") String address) {
        List<Car> list = carService.getOwnerAdress(currentOwnerName, address);
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}