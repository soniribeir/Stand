package com.example.stand.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Stand {

    @Id
    @GeneratedValue
    long standID;
    String standName;
    String standAddress;
    String standPhoneNumber;
    Integer standNif;
    String standEmailAddress;

    public Stand(long standID, String standName, String standAddress, String standPhoneNumber, Integer standNif, String standEmailAddress) {
        this.standID = standID;
        this.standName = standName;
        this.standAddress = standAddress;
        this.standPhoneNumber = standPhoneNumber;
        this.standNif = standNif;
        this.standEmailAddress = standEmailAddress;
    }
    public Stand(){}

    public long getStandID() {
        return standID;
    }

    public String getStandName() {
        return standName;
    }

    public String getStandAddress() {
        return standAddress;
    }

    public String getStandPhoneNumber() {
        return standPhoneNumber;
    }

    public Integer getStandNif() {
        return standNif;
    }

    public String getStandEmailAddress() {
        return standEmailAddress;
    }

    public void setStandName(String standName) {
        this.standName = standName;
    }

    public void setStandAddress(String standAddress) {
        this.standAddress = standAddress;
    }

    public void setStandPhoneNumber(String standPhoneNumber) {
        this.standPhoneNumber = standPhoneNumber;
    }

    public void setStandNif(Integer standNif) {
        this.standNif = standNif;
    }

    public void setStandEmailAddress(String standEmailAddress) {
        this.standEmailAddress = standEmailAddress;
    }
}
