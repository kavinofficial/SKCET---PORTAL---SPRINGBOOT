package com.kavin.q4.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q4.model.Patient;
import com.kavin.q4.service.PatientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    public PatientService patientService;

    @GetMapping("")
    public ResponseEntity<List<Patient>> getMethodName() {
        List<Patient> list = patientService.getList();
        if (list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Patient> postMethodName(@RequestBody Patient entity) {
        if (patientService.addPatient(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getMethodName(@PathVariable int id) {
        if (patientService.getId(id) != null) {
            return new ResponseEntity<>(patientService.getId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
