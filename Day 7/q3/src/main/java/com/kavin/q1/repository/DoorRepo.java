package com.kavin.q1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kavin.q1.model.Door;
import java.util.List;

public interface DoorRepo extends JpaRepository<Door, Integer> {
    List<Door> findByDoorId(int doorId);

    List<Door> findByAccessType(String accessType);
}
