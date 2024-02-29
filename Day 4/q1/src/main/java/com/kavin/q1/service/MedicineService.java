package com.kavin.q1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Medicine;
import com.kavin.q1.repository.MedicineRepo;

@Service
public class MedicineService {
    @Autowired
    public MedicineRepo medicineRepo;

    public boolean addMedicine(Medicine m) {
        try {
            medicineRepo.save(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Medicine> getMedicines() {
        return new ArrayList<>(medicineRepo.findAll());
    }

    public Optional<Medicine> getId(int id) {
        return medicineRepo.findById(id);
    }
}
