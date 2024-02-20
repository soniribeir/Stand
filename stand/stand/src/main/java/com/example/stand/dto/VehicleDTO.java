package com.example.stand.dto;

import com.example.stand.enums.Fuel;
import com.example.stand.enums.Status;
import com.example.stand.enums.Traction;
import com.example.stand.enums.Type;
import com.example.stand.models.Brand;
import com.example.stand.models.Client;
import com.example.stand.models.Model;
import jakarta.persistence.Enumerated;
import org.springframework.hateoas.RepresentationModel;

public class VehicleDTO extends RepresentationModel<VehicleDTO> {

    long vehicleIdDTO;
    String vehicleNameDTO;
    String vehicleLicensePlateDTO;
    Integer vehicleNumberSeatsDTO;
    Integer vehicleNumberDoorsDTO;
    @Enumerated
    Traction vehicleTractionDTO;
    @Enumerated
    Fuel vehicleFuelDTO;
    String vehicleColorDTO;
    @Enumerated
    Type vehicleTypeDTO;
    @Enumerated
    Status vehicleStatusDTO;
    Client client;
    Model model;

    long buyerId;

    long transactionId;

    public VehicleDTO(long vehicleIdDTO, String vehicleNameDTO, String vehicleLicensePlateDTO, Integer vehicleNumberSeatsDTO, Integer vehicleNumberDoorsDTO, Traction vehicleTractionDTO, Fuel vehicleFuelDTO, String vehicleColorDTO, Type vehicleTypeDTO, Status vehicleStatusDTO, Client client, Model model) {
        this.vehicleIdDTO = vehicleIdDTO;
        this.vehicleNameDTO = vehicleNameDTO;
        this.vehicleLicensePlateDTO = vehicleLicensePlateDTO;
        this.vehicleNumberSeatsDTO = vehicleNumberSeatsDTO;
        this.vehicleNumberDoorsDTO = vehicleNumberDoorsDTO;
        this.vehicleTractionDTO = vehicleTractionDTO;
        this.vehicleFuelDTO = vehicleFuelDTO;
        this.vehicleColorDTO = vehicleColorDTO;
        this.vehicleTypeDTO = vehicleTypeDTO;
        this.vehicleStatusDTO = vehicleStatusDTO;
        this.client = client;
        this.model = model;
    }

    public long getVehicleIdDTO() {
        return vehicleIdDTO;
    }

    public String getVehicleNameDTO() {
        return vehicleNameDTO;
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

    public void setVehicleNameDTO(String vehicleNameDTO) {
        this.vehicleNameDTO = vehicleNameDTO;
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
}
