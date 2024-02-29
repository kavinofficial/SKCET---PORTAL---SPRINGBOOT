package com.kavin.q1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Medicine;
import com.kavin.q1.service.MedicineService;

@RestController
@RequestMapping("api")
public class MedicineController {
    @Autowired
    public MedicineService service;

    @PostMapping("/medicine")
    public ResponseEntity<Medicine> post(@RequestBody Medicine entity) {
        if (service.addMedicine(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> get() {
        List<Medicine> med = service.getMedicines();
        if (med.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<Medicine>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.getMedicines(), HttpStatus.OK);
    }

    @GetMapping("/medicine/{medicineid}")
    public ResponseEntity<Optional<Medicine>> getId(@PathVariable int medicineid) {
        if (service.getId(medicineid).isPresent()) {
            return new ResponseEntity<>(service.getId(medicineid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
