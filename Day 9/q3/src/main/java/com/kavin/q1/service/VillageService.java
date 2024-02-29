package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.Repository.VillageRepo;
import com.kavin.q1.model.Village;

@Service
public class VillageService {
    @Autowired
    private VillageRepo villageRepo;

    public Village post(Village p) {
        return villageRepo.save(p);
    }

    public Village get(int villageId) {
        return villageRepo.findvillageId(villageId);
    }

    public Village getName(String villageName) {
        return villageRepo.findVillageName(villageName);
    }

    public List<Village> getPoplation(int villagePopulation) {
        return villageRepo.findVillagePopulation(villagePopulation);
    }
}
