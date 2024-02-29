package com.kavin.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kavin.q1.model.Village;
import com.kavin.q1.service.VillageService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class VillageController {
    @Autowired
    private VillageService villageService;

    @PostMapping("/village")
    public ResponseEntity<Village> getMethodName(@RequestBody Village param) {
        Village p = villageService.post(param);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/village/{villageId}")
    public ResponseEntity<Village> getMethodName(@PathVariable("villageId") int villageId) {
        Village p = villageService.get(villageId);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/village/byname/{villageName}")
    public ResponseEntity<Village> getMethodName(@PathVariable("villageName") String villageName) {
        Village p = villageService.getName(villageName);
        if (p != null) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/village/bypopulation/{villagePopulation}")
    public ResponseEntity<List<Village>> getPopulation(@PathVariable("villagePopulation") int villagePopulation) {
        List<Village> list = villageService.getPoplation(villagePopulation);
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
