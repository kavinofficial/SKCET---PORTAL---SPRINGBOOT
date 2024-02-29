package com.kavin.q4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q4.model.Patient;
import com.kavin.q4.repository.PatientRepo;

@Service
public class PatientService {
    @Autowired
    public PatientRepo patientRepo;

    public List<Patient> getList() {
        return patientRepo.findAll();
    }

    @SuppressWarnings("null")
    public boolean addPatient(Patient p) {
        try {
            patientRepo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Patient getId(int id) {
        try {
            Patient p = patientRepo.findById(id).orElse(null);
            return p;
        } catch (Exception e) {
            return null;
        }
    }
}
