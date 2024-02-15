package com.example.stand.models;

import jakarta.persistence.*;

@Entity
public class Model {
    @Id
    @GeneratedValue
    long modelID;
    String modelName;
    @OneToMany
    Brand brandName;

    public Model(long modelID, String modelName, Brand brandName) {
        this.modelID = modelID;
        this.modelName = modelName;
        this.brandName = brandName;
    }
    public Model(){}

    public long getModelID() {
        return modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }
}
