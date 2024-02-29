package com.kavin.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavin.q1.model.Door;
import com.kavin.q1.repository.DoorRepo;

@Service
public class DoorService {
    @Autowired
    private DoorRepo doorRepo;

    public Door postPerson(Door p) {
        return doorRepo.save(p);
    }

    public List<Door> getPerson() {
        return doorRepo.findAll();
    }

    public List<Door> getDoorById(int doorId) {
        return doorRepo.findByDoorId(doorId);
    }

    public List<Door> getDoorAccess(String access) {
        return doorRepo.findByAccessType(access);
    }
}
