package com.example.stand.controllers;

import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.models.Client;
import com.example.stand.models.Vehicle;
import com.example.stand.services.ClientRepository;
import com.example.stand.services.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getVehicleName(), vehicle.getVehicleLicensePlate(), vehicle.getVehicleNumberSeats(), vehicle.getVehicleNumberDoors(), vehicle.getVehicleTraction(), vehicle.getVehicleFuel(), vehicle.getVehicleColor(), vehicle.getVehicleType(), vehicle.getVehicleStatus(), vehicle.getClient(), vehicle.getModel());
        vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicles()).withSelfRel());
        return new ResponseEntity<>(vehicleDTO,HttpStatus.OK);
    }

    @GetMapping(value="/vehicles", produces = "application/json")
    public CollectionModel<VehicleDTO> getVehicles(){

        List<Vehicle> listVehicles = vehicleRepository.findAll();

        List<VehicleDTO> listVehicleDTO = new ArrayList<>();

        for(Vehicle v: listVehicles){
            VehicleDTO vDTO = new VehicleDTO(v.getVehicleName(), v.getVehicleLicensePlate(), v.getVehicleNumberSeats(), v.getVehicleNumberDoors(), v.getVehicleTraction(), v.getVehicleFuel(), v.getVehicleColor(),v.getVehicleType(), v.getVehicleStatus(), v.getClient(), v.getModel());
            vDTO.add(linkTo(methodOn(StandController.class).getVehicle(v.getVehicleID())).withSelfRel());
            listVehicleDTO.add(vDTO);
        }
        Link link = linkTo(methodOn(StandController.class).getVehicles()).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(listVehicleDTO, link);
        return resp;
    }

    @PostMapping(value= "/vehicle", consumes= "application/json", produces= "application/json")
    public HttpEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle(vehicleDTO.getVehicleNameDTO(), vehicleDTO.getVehicleLicensePlateDTO(), vehicleDTO.getVehicleNumberSeatsDTO(), vehicleDTO.getVehicleNumberDoorsDTO(), vehicleDTO.getVehicleTractionDTO(), vehicleDTO.getVehicleFuelDTO(), vehicleDTO.getVehicleColorDTO(), vehicleDTO.getVehicleTypeDTO(), vehicleDTO.getVehicleStatusDTO(), vehicleDTO.getClient(), vehicleDTO.getModel());

        Vehicle vehicle1 = vehicleRepository.saveAndFlush(vehicle);
        VehicleDTO resp = new VehicleDTO(vehicle1.getVehicleName(), vehicle1.getVehicleLicensePlate(), vehicle1.getVehicleNumberSeats(), vehicle1.getVehicleNumberDoors(), vehicle1.getVehicleTraction(), vehicle1.getVehicleFuel(), vehicle1.getVehicleColor(), vehicle1.getVehicleType(), vehicle1.getVehicleStatus(), vehicle1.getClient(), vehicle1.getModel());
        resp.add(linkTo(methodOn(StandController.class).getVehicle(vehicle.getVehicleID())).withSelfRel());
        resp.add(linkTo(methodOn(StandController.class).getVehicles()).withRel("ver_todos_veiculos"));
        resp.add(linkTo(methodOn(StandController.class).updateVehicle(vehicle.getVehicleID(), vehicleDTO)).withRel("update"));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @PutMapping(value= "/vehicle/{id}", consumes = "application/json")
    public VehicleDTO updateVehicle(@PathVariable("id") long id, @RequestBody VehicleDTO vehicleDTO) {

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();

            existingVehicle.setVehicleName(vehicleDTO.getVehicleNameDTO());
            existingVehicle.setVehicleLicensePlate(vehicleDTO.getVehicleLicensePlateDTO());
            existingVehicle.setVehicleNumberSeats(vehicleDTO.getVehicleNumberSeatsDTO());
            existingVehicle.setVehicleNumberDoors(vehicleDTO.getVehicleNumberDoorsDTO());
            existingVehicle.setVehicleTraction(vehicleDTO.getVehicleTractionDTO());
            existingVehicle.setVehicleFuel(vehicleDTO.getVehicleFuelDTO());
            existingVehicle.setVehicleColor(vehicleDTO.getVehicleColorDTO());
            existingVehicle.setVehicleType(vehicleDTO.getVehicleTypeDTO());
            existingVehicle.setVehicleStatus(vehicleDTO.getVehicleStatusDTO());
            existingVehicle.setClient(vehicleDTO.getClient());
            existingVehicle.setModel(vehicleDTO.getModel());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleDTO(updatedVehicle.getVehicleName(), updatedVehicle.getVehicleLicensePlate(), updatedVehicle.getVehicleNumberSeats(), updatedVehicle.getVehicleNumberDoors(), updatedVehicle.getVehicleTraction(), updatedVehicle.getVehicleFuel(), updatedVehicle.getVehicleColor(), updatedVehicle.getVehicleType(), updatedVehicle.getVehicleStatus(), updatedVehicle.getClient(), updatedVehicle.getModel());
        } else {
            return null;
        }
    }

    ///////////////////////////////////////////////7
    @GetMapping(value= "/client/{id}", produces = "application/json")
    public ResponseEntity<ClientDTO> getClient(@PathVariable("id") long id){
        Client client = clientRepository.findById(id).get();
        if (client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ClientDTO clientDTO = new ClientDTO(client.getClientName(), client.getClientAddress(), client.getClientPhoneNumber(), client.getClientNif(), client.getClientEmailAddress(), client.getStand());
        clientDTO.add(linkTo(methodOn(StandController.class).getClients()).withSelfRel());
        return new ResponseEntity<>(clientDTO,HttpStatus.OK);
    }

    @GetMapping(value="/clients", produces = "application/json")
    public CollectionModel<ClientDTO> getClients(){

        List<Client> listClients = clientRepository.findAll();

        List<ClientDTO> listClientsDTO = new ArrayList<>();

        for(Client c: listClients){
            ClientDTO cDTO = new ClientDTO(c.getClientName(), c.getClientAddress(), c.getClientPhoneNumber(), c.getClientNif(), c.getClientEmailAddress(), c.getStand());
            cDTO.add(linkTo(methodOn(StandController.class).getClient(c.getClientID())).withSelfRel());
            listClientsDTO.add(cDTO);
        }
        Link link = linkTo(methodOn(StandController.class).getClients()).withSelfRel();
        CollectionModel<ClientDTO> resp = CollectionModel.of(listClientsDTO, link);
        return resp;
    }


    @PostMapping(value= "/client", consumes= "application/json", produces= "application/json")
    public HttpEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getClientNameDTO(), clientDTO.getClientAddressDTO(), clientDTO.getClientPhoneNumberDTO(), clientDTO.getClientNifDTO(), clientDTO.getClientEmailAddressDTO(), clientDTO.getStand());

        Client client1 = clientRepository.saveAndFlush(client);
        ClientDTO resp = new ClientDTO(client1.getClientName(), client1.getClientAddress(), client1.getClientPhoneNumber(), client1.getClientNif(), client1.getClientEmailAddress(), client1.getStand());
        resp.add(linkTo(methodOn(StandController.class).getClient(client.getClientID())).withSelfRel());
        resp.add(linkTo(methodOn(StandController.class).getClients()).withRel("ver_todos_clientes"));
        resp.add(linkTo(methodOn(StandController.class).updateClient(client.getClientID(), clientDTO)).withRel("update"));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping(value= "/client/{id}", consumes = "application/json")
    public ClientDTO updateClient(@PathVariable("id") long id, @RequestBody ClientDTO clientDTO) {

        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();

            existingClient.setClientName(clientDTO.getClientNameDTO());
            existingClient.setClientAddress(clientDTO.getClientAddressDTO());
            existingClient.setClientPhoneNumber(clientDTO.getClientPhoneNumberDTO());
            existingClient.setClientNif(clientDTO.getClientNifDTO());
            existingClient.setClientEmailAddress(clientDTO.getClientEmailAddressDTO());
            existingClient.setStand(clientDTO.getStand());

            Client updatedClient = clientRepository.save(existingClient);

            return new ClientDTO(updatedClient.getClientName(), updatedClient.getClientAddress(), updatedClient.getClientPhoneNumber(), updatedClient.getClientNif(), updatedClient.getClientEmailAddress(), updatedClient.getStand());
        } else {
            return null;
        }
    }

    ////////////////////////////
    @PutMapping(value= "/vehicle/status/{id}", consumes = "application/json")
    public VehicleDTO updateVehicleStatus(@PathVariable("id") long id, @RequestBody VehicleDTO vehicleDTO) {

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();

            existingVehicle.setVehicleStatus(vehicleDTO.getVehicleStatusDTO());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleDTO(updatedVehicle.getVehicleName(), updatedVehicle.getVehicleLicensePlate(), updatedVehicle.getVehicleNumberSeats(), updatedVehicle.getVehicleNumberDoors(), updatedVehicle.getVehicleTraction(), updatedVehicle.getVehicleFuel(), updatedVehicle.getVehicleColor(), updatedVehicle.getVehicleType(), updatedVehicle.getVehicleStatus(), updatedVehicle.getClient(), updatedVehicle.getModel());
        } else {
            return null;
        }
    }
}
