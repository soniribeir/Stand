package com.example.stand.models;

import com.example.stand.enums.Fuel;
import com.example.stand.enums.Status;
import com.example.stand.enums.Traction;
import com.example.stand.enums.Type;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    Long vehicleID;
    String vehicleName;
    String vehicleLicensePlate;
    Integer vehicleNumberSeats;
    Integer vehicleNumberDoors;
    @Enumerated
    Traction vehicleTraction;
    @Enumerated
    Fuel vehicleFuel;
    String vehicleColor;
    @Enumerated
    Type vehicleType;
    @Enumerated
    Status vehicleStatus;
    @ManyToOne
    Client client;
    @ManyToOne
    Model model;

    Long buyerId;
    Long transactionId;

    double purchasePrice;

    double sellingPrice;

    public Vehicle(Long vehicleID, String vehicleName, String vehicleLicensePlate, Integer vehicleNumberSeats, Integer vehicleNumberDoors, Traction vehicleTraction, Fuel vehicleFuel, String vehicleColor, Type vehicleType, Status vehicleStatus, Client client, Model model, double purchasePrice, double sellingPrice) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleNumberSeats = vehicleNumberSeats;
        this.vehicleNumberDoors = vehicleNumberDoors;
        this.vehicleTraction = vehicleTraction;
        this.vehicleFuel = vehicleFuel;
        this.vehicleColor = vehicleColor;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
        this.client = client;
        this.model = model;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public Vehicle() {}

    public long getVehicleID() {
        return vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public Integer getVehicleNumberSeats() {
        return vehicleNumberSeats;
    }

    public Integer getVehicleNumberDoors() {
        return vehicleNumberDoors;
    }

    public Traction getVehicleTraction() {
        return vehicleTraction;
    }

    public Fuel getVehicleFuel() {
        return vehicleFuel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public Type getVehicleType() {
        return vehicleType;
    }

    public Status getVehicleStatus() {
        return vehicleStatus;
    }

    public Client getClient() {
        return client;
    }

    public Model getModel() {
        return model;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public void setVehicleNumberSeats(Integer vehicleNumberSeats) {
        this.vehicleNumberSeats = vehicleNumberSeats;
    }

    public void setVehicleNumberDoors(Integer vehicleNumberDoors) {
        this.vehicleNumberDoors = vehicleNumberDoors;
    }

    public void setVehicleTraction(Traction vehicleTraction) {
        this.vehicleTraction = vehicleTraction;
    }

    public void setVehicleFuel(Fuel vehicleFuel) {
        this.vehicleFuel = vehicleFuel;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public void setVehicleType(Type vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleStatus(Status vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}

