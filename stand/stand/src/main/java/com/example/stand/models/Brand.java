package com.example.stand.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    long brandID;
    String brandName;

    public Brand(long brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }
    public Brand(){}

    public long getBrandID() {
        return brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
