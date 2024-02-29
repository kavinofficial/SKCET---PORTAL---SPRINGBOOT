package com.kavin.q1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Village {
    @Id
    private int villageId;
    private String villageName;
    private int numOfMen;
    private int numOfWomen;
    private int villagePopulation;
    private int numOfSchools;

    public int getVillageId() {
        return villageId;
    }

    public void setVillageId(int villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public int getNumOfMen() {
        return numOfMen;
    }

    public void setNumOfMen(int numOfMen) {
        this.numOfMen = numOfMen;
    }

    public int getNumOfWomen() {
        return numOfWomen;
    }

    public void setNumOfWomen(int numOfWomen) {
        this.numOfWomen = numOfWomen;
    }

    public int getVillagePopulation() {
        return villagePopulation;
    }

    public void setVillagePopulation(int villagePopulation) {
        this.villagePopulation = villagePopulation;
    }

    public int getNumOfSchools() {
        return numOfSchools;
    }

    public void setNumOfSchools(int numOfSchools) {
        this.numOfSchools = numOfSchools;
    }

}
