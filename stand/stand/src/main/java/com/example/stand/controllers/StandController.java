package com.example.stand.controllers;

import com.example.stand.dto.VehicleDTO;
import com.example.stand.models.Vehicle;
import com.example.stand.services.ClientRepository;
import com.example.stand.services.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StandController {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value= "/vehicle/{id}", produces = "application/json")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable("id") long id){
        Vehicle vehicle = vehicleRepository.findById(id).get();
        if (vehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getVehicleName(), vehicle.getVehicleModel(), vehicle.getVehicleLicensePlate(), vehicle.getVehicleNumberSeats(), vehicle.getVehicleNumberDoors(), vehicle.getVehicleTraction(), vehicle.getVehicleFuel(), vehicle.getVehicleColor(), vehicle.getVehicleType(), vehicle.getVehicleStatus(), vehicle.getClient(), vehicle.getModel());
    }

    @GetMapping(value="/vehicles", produces = "application/json")
    public CollectionModel<VehicleDTO> getVehicles(){
        List<Vehicle> listVehicles = vehicleRepository.findAll();
        List<VehicleDTO> listVehicleDTO = new ArrayList<>();
        for(VehicleDTO u: listVehicles){
            VehicleDTO uDTO = new VehicleDTO(u.getVehicleNameDTO(), )
        }
    }
}
