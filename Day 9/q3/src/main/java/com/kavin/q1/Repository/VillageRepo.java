package com.kavin.q1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kavin.q1.model.Village;

public interface VillageRepo extends JpaRepository<Village, Integer> {
    @Query("SELECT p FROM Village p WHERE p.villageId =:villageId")
    Village findvillageId(@Param("villageId") int villageId);

    @Query("SELECT p FROM Village p WHERE p.villageName =:villageName")
    Village findVillageName(String villageName);

    @Query("SELECT p FROM Village p WHERE p.villagePopulation=:villagePopulation")
    List<Village> findVillagePopulation(int villagePopulation);
}
