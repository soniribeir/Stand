package com.example.stand.dto;

import com.example.stand.enums.Fuel;
import com.example.stand.enums.Status;
import com.example.stand.enums.Traction;
import com.example.stand.enums.Type;
import com.example.stand.models.Brand;
import com.example.stand.models.Model;

public class VehicleDTO {
    String vehicleNameDTO;
    Brand vehicleBrandDTO;
    Model vehicleModelDTO;
    String vehicleLicensePlateDTO;
    Integer vehicleNumberSeatsDTO;
    Integer vehicleNumberDoorsDTO;
    Traction vehicleTractionDTO;
    Fuel vehicleFuelDTO;
    String vehicleColorDTO;
    Type vehicleTypeDTO;
    Status vehicleStatusDTO;

    public VehicleDTO(String vehicleNameDTO, Brand vehicleBrandDTO, Model vehicleModelDTO, String vehicleLicensePlateDTO, Integer vehicleNumberSeatsDTO, Integer vehicleNumberDoorsDTO, Traction vehicleTractionDTO, Fuel vehicleFuelDTO, String vehicleColorDTO, Type vehicleTypeDTO, Status vehicleStatusDTO) {
        this.vehicleNameDTO = vehicleNameDTO;
        this.vehicleBrandDTO = vehicleBrandDTO;
        this.vehicleModelDTO = vehicleModelDTO;
        this.vehicleLicensePlateDTO = vehicleLicensePlateDTO;
        this.vehicleNumberSeatsDTO = vehicleNumberSeatsDTO;
        this.vehicleNumberDoorsDTO = vehicleNumberDoorsDTO;
        this.vehicleTractionDTO = vehicleTractionDTO;
        this.vehicleFuelDTO = vehicleFuelDTO;
        this.vehicleColorDTO = vehicleColorDTO;
        this.vehicleTypeDTO = vehicleTypeDTO;
        this.vehicleStatusDTO = vehicleStatusDTO;
    }

    public String getVehicleNameDTO() {
        return vehicleNameDTO;
    }

    public Brand getVehicleBrandDTO() {
        return vehicleBrandDTO;
    }

    public Model getVehicleModelDTO() {
        return vehicleModelDTO;
    }

    public String getVehicleLicensePlateDTO() {
        return vehicleLicensePlateDTO;
    }

    public Integer getVehicleNumberSeatsDTO() {
        return vehicleNumberSeatsDTO;
    }

    public Integer getVehicleNumberDoorsDTO() {
        return vehicleNumberDoorsDTO;
    }

    public Traction getVehicleTractionDTO() {
        return vehicleTractionDTO;
    }

    public Fuel getVehicleFuelDTO() {
        return vehicleFuelDTO;
    }

    public String getVehicleColorDTO() {
        return vehicleColorDTO;
    }

    public Type getVehicleTypeDTO() {
        return vehicleTypeDTO;
    }

    public Status getVehicleStatusDTO() {
        return vehicleStatusDTO;
    }

    public void setVehicleNameDTO(String vehicleNameDTO) {
        this.vehicleNameDTO = vehicleNameDTO;
    }

    public void setVehicleBrandDTO(Brand vehicleBrandDTO) {
        this.vehicleBrandDTO = vehicleBrandDTO;
    }

    public void setVehicleModelDTO(Model vehicleModelDTO) {
        this.vehicleModelDTO = vehicleModelDTO;
    }

    public void setVehicleLicensePlateDTO(String vehicleLicensePlateDTO) {
        this.vehicleLicensePlateDTO = vehicleLicensePlateDTO;
    }

    public void setVehicleNumberSeatsDTO(Integer vehicleNumberSeatsDTO) {
        this.vehicleNumberSeatsDTO = vehicleNumberSeatsDTO;
    }

    public void setVehicleNumberDoorsDTO(Integer vehicleNumberDoorsDTO) {
        this.vehicleNumberDoorsDTO = vehicleNumberDoorsDTO;
    }

    public void setVehicleTractionDTO(Traction vehicleTractionDTO) {
        this.vehicleTractionDTO = vehicleTractionDTO;
    }

    public void setVehicleFuelDTO(Fuel vehicleFuelDTO) {
        this.vehicleFuelDTO = vehicleFuelDTO;
    }

    public void setVehicleColorDTO(String vehicleColorDTO) {
        this.vehicleColorDTO = vehicleColorDTO;
    }

    public void setVehicleTypeDTO(Type vehicleTypeDTO) {
        this.vehicleTypeDTO = vehicleTypeDTO;
    }

    public void setVehicleStatusDTO(Status vehicleStatusDTO) {
        this.vehicleStatusDTO = vehicleStatusDTO;
    }
}
