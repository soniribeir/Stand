package com.example.stand.models;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    long clientID;
    String clientName;
    String clientAddress;
    String clientPhoneNumber;
    Integer clientNif;
    String clientEmailAddress;
    @OneToMany
    Stand stand;

    public Client(long clientID, String clientName, String clientAddress, String clientPhoneNumber, Integer clientNif, String clientEmailAddress, Stand stand) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientNif = clientNif;
        this.clientEmailAddress = clientEmailAddress;
        this.stand = stand;
    }
    public Client(){}

    public long getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public Integer getClientNif() {
        return clientNif;
    }

    public String getClientEmailAddress() {
        return clientEmailAddress;
    }

    public Stand getStand() {
        return stand;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public void setClientNif(Integer clientNif) {
        this.clientNif = clientNif;
    }

    public void setClientEmailAddress(String clientEmailAddress) {
        this.clientEmailAddress = clientEmailAddress;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }
}
