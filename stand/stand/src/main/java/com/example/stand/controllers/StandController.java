package com.example.stand.controllers;

import com.example.stand.dto.BrandDTO;
import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.ModelDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.enums.Status;
import com.example.stand.models.Brand;
import com.example.stand.models.Client;
import com.example.stand.models.Vehicle;
import com.example.stand.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDslKt.withRel;

@RestController
public class StandController {

    @Autowired
    private final MyStorageImpl myStorage;

    public StandController(MyStorageImpl myStorage) {
        this.myStorage = myStorage;
    }

    @GetMapping(value= "/vehicle/{id}", produces = "application/json")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable("id") long id){

        VehicleDTO vehicleDTO = myStorage.getVehicle(id);

        if (vehicleDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicles()).withSelfRel());
        return new ResponseEntity<>(vehicleDTO,HttpStatus.OK);
    }

    @GetMapping(value="/vehicles", produces = "application/json")
    public ResponseEntity<CollectionModel<VehicleDTO>> getVehicles(){

        Collection<VehicleDTO> listVehiclesDTO = myStorage.getAllVehicles();
        if(listVehiclesDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(VehicleDTO vehicleDTO : listVehiclesDTO){
            vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(vehicleDTO.getVehicleIdDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getVehicles()).withSelfRel();
        CollectionModel<VehicleDTO> response = CollectionModel.of(listVehiclesDTO, link);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value= "/vehicle", consumes= "application/json", produces= "application/json")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {

        VehicleDTO addedVehicleDTO = myStorage.addVehicle(vehicleDTO);

        addedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(addedVehicleDTO.getVehicleIdDTO())).withSelfRel());
        addedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicles()).withRel("ver_todos_veiculos"));
        addedVehicleDTO.add(linkTo(methodOn(StandController.class).updateVehicle(addedVehicleDTO.getVehicleIdDTO(), vehicleDTO)).withRel("update"));
        return new ResponseEntity<>(addedVehicleDTO, HttpStatus.CREATED);
    }

    @PutMapping(value= "/vehicle/update/{id}", consumes = "application/json")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("id") long id, @RequestBody VehicleDTO vehicleDTO) {

        VehicleDTO updatedVehicleDTO =myStorage.updateVehicle(vehicleDTO);

        if (updatedVehicleDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(id)).withSelfRel());
        updatedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicles()).withRel("ver_todos_veiculos"));

        return new ResponseEntity<>(updatedVehicleDTO, HttpStatus.OK);
    }

    @DeleteMapping(value="/vehicle/delete/{id}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable("id") long id){

        VehicleDTO deletedVehicleDTO = myStorage.deleteVehicle(id);

        if(deletedVehicleDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value= "/buy-vehicle/{vahicleId}", consumes= "application/json", produces= "application/json")
    public ResponseEntity<VehicleDTO> buyVehicle(@PathVariable("vehicleId") long vehicleId, @RequestParam long clientId, @RequestParam long transactionId) {

        VehicleDTO updatedVehicleDTO = myStorage.buyVehicle(vehicleId, clientId, transactionId);

        if(updatedVehicleDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(updatedVehicleDTO.getVehicleIdDTO())).withSelfRel());
        updatedVehicleDTO.add(linkTo(methodOn(StandController.class).getVehicles()).withRel("ver_todos_veiculos"));
        updatedVehicleDTO.add(linkTo(methodOn(StandController.class).updateVehicle(updatedVehicleDTO.getVehicleIdDTO(), updatedVehicleDTO)).withRel("update"));
        return new ResponseEntity<>(updatedVehicleDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/vehicle/{vehicleId}/status/")
    public ResponseEntity<String> updatedVehicleStatus(@PathVariable("vehicleId") long vehicleId, @RequestParam("newStatus") Status newStatus){
        int rowsAffected = myStorage.updateVehicleStatus(vehicleId, newStatus);

        if(rowsAffected>0){
            return ResponseEntity.ok("Vehicle status updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found or status not updated");
        }
    }

    @PutMapping(value="/vehicle/update/status-sold/{id}")
    public ResponseEntity<VehicleDTO> updateStatusToSold(@PathVariable("id") long id){

        VehicleDTO updatedStatus = myStorage.updateAsSold(id);

        if(updatedStatus == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedStatus.add(linkTo(methodOn(StandController.class).getVehicle(id)).withSelfRel());
        updatedStatus.add(linkTo(methodOn(StandController.class).getVehicles()).withRel("ver_todos_os_veículos"));

        return new ResponseEntity<>(updatedStatus, HttpStatus.OK);
    }

    @GetMapping(value = "/vehicles/status-stock", produces = "application/json")
    public ResponseEntity<CollectionModel<VehicleDTO>> getVehiclesStock(){

        Collection<VehicleDTO> listVehiclesStockDTO = myStorage.getVehiclesStock();
        if(listVehiclesStockDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for(VehicleDTO vehicleDTO : listVehiclesStockDTO ){
            vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(vehicleDTO.getVehicleIdDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getVehicles()).withSelfRel();
        CollectionModel<VehicleDTO> response = CollectionModel.of(listVehiclesStockDTO, link);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/vehicles/status-sold", produces = "application/json")
    public ResponseEntity<CollectionModel<VehicleDTO>> getVehiclesSold(){

        Collection<VehicleDTO> listVehiclesSoldDTO = myStorage.getVehiclesSold();
        if(listVehiclesSoldDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for(VehicleDTO vehicleDTO : listVehiclesSoldDTO ){
            vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(vehicleDTO.getVehicleIdDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getVehicles()).withSelfRel();
        CollectionModel<VehicleDTO> response = CollectionModel.of(listVehiclesSoldDTO, link);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value= "/vehicles/client/{id}", produces = "application/json")
    public ResponseEntity<CollectionModel<VehicleDTO>> getVehiclesByClientId(@PathVariable("id") long id){

        Collection<VehicleDTO> listVehiclesByClientID = myStorage.getVehiclesByClient(id);
        if(listVehiclesByClientID.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for(VehicleDTO vehicleDTO : listVehiclesByClientID ){
            vehicleDTO.add(linkTo(methodOn(StandController.class).getVehicle(vehicleDTO.getVehicleIdDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getVehicles()).withSelfRel();
        CollectionModel<VehicleDTO> response = CollectionModel.of(listVehiclesByClientID, link);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    ///////////////////////////////////////////////CLIENT////////

    @GetMapping(value= "/client/{id}", produces = "application/json")
    public ResponseEntity<ClientDTO> getClient(@PathVariable("id") long id){

        ClientDTO clientDTO = myStorage.getClient(id);

        if (clientDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        clientDTO.add(linkTo(methodOn(StandController.class).getClients()).withSelfRel());
        return new ResponseEntity<>(clientDTO,HttpStatus.OK);
    }

    @GetMapping(value="/clients", produces = "application/json")
    public ResponseEntity<CollectionModel<ClientDTO>> getClients(){

        Collection<ClientDTO> listClientsDTO = myStorage.getAllClients();
        if(listClientsDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(ClientDTO clientDTO : listClientsDTO){
            clientDTO.add(linkTo(methodOn(StandController.class).getClient(clientDTO.getClientIDDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getClients()).withSelfRel();
        CollectionModel<ClientDTO> response = CollectionModel.of(listClientsDTO, link);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(value= "/client", consumes= "application/json", produces= "application/json")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {

        ClientDTO addedClientDTO = myStorage.addClient(clientDTO);

        addedClientDTO.add(linkTo(methodOn(StandController.class).getClient(addedClientDTO.getClientIDDTO())).withSelfRel());
        addedClientDTO.add(linkTo(methodOn(StandController.class).getClients()).withRel("ver_todos_clientes"));
        addedClientDTO.add(linkTo(methodOn(StandController.class).updateClient(addedClientDTO.getClientIDDTO(), clientDTO)).withRel("update"));
        return new ResponseEntity<>(addedClientDTO, HttpStatus.CREATED);
    }

    @PutMapping(value= "/client/update/{id}", consumes = "application/json")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("id") long id, @RequestBody ClientDTO clientDTO) {

        ClientDTO updatedClientDTO =myStorage.updateClient(clientDTO);

        if (updatedClientDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedClientDTO.add(linkTo(methodOn(StandController.class).getClient(id)).withSelfRel());
        updatedClientDTO.add(linkTo(methodOn(StandController.class).getClients()).withRel("ver_todos_clients"));

        return new ResponseEntity<>(updatedClientDTO, HttpStatus.OK);
    }

    @DeleteMapping(value="/client/delete/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("id") long id){

        ClientDTO deletedClientDTO = myStorage.deleteClient(id);

        if(deletedClientDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //////////////////////BRAND/////

    @GetMapping(value= "/brand/{id}", produces = "application/json")
    public ResponseEntity<BrandDTO> getBrand(@PathVariable("id") long id){

        BrandDTO brandDTO = myStorage.getBrand(id);

        if (brandDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        brandDTO.add(linkTo(methodOn(StandController.class).getBrands()).withSelfRel());
        return new ResponseEntity<>(brandDTO,HttpStatus.OK);
    }

    @GetMapping(value="/brands", produces = "application/json")
    public ResponseEntity<CollectionModel<BrandDTO>> getBrands(){

        Collection<BrandDTO> listBrandsDTO = myStorage.getAllBrands();
        if(listBrandsDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(BrandDTO brandDTO : listBrandsDTO){
            brandDTO.add(linkTo(methodOn(StandController.class).getBrand(brandDTO.getBrandIDDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getBrands()).withSelfRel();
        CollectionModel<BrandDTO> response = CollectionModel.of(listBrandsDTO, link);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value= "/brand", consumes= "application/json", produces= "application/json")
    public ResponseEntity<BrandDTO> addBrand(@RequestBody BrandDTO brandDTO) {

        BrandDTO addedBrandDTO = myStorage.addBrand(brandDTO);

        addedBrandDTO.add(linkTo(methodOn(StandController.class).getBrand(addedBrandDTO.getBrandIDDTO())).withSelfRel());
        addedBrandDTO.add(linkTo(methodOn(StandController.class).getBrands()).withRel("ver_todas_brands"));
        addedBrandDTO.add(linkTo(methodOn(StandController.class).updateBrand(addedBrandDTO.getBrandIDDTO(), brandDTO)).withRel("update"));
        return new ResponseEntity<>(addedBrandDTO, HttpStatus.CREATED);
    }

    @PutMapping(value= "/brand/update/{id}", consumes = "application/json")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable("id") long id, @RequestBody BrandDTO brandDTO) {

        BrandDTO updatedBrandDTO =myStorage.updateBrand(brandDTO);

        if ( updatedBrandDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedBrandDTO.add(linkTo(methodOn(StandController.class).getBrand(id)).withSelfRel());
        updatedBrandDTO.add(linkTo(methodOn(StandController.class).getBrands()).withRel("ver_todas_brands"));

        return new ResponseEntity<>( updatedBrandDTO, HttpStatus.OK);
    }

    @DeleteMapping(value="/brand/delete/{id}")
    public ResponseEntity<BrandDTO> deleteBrand(@PathVariable("id") long id){

        BrandDTO deletedBrandDTO = myStorage.deleteBrand(id);

        if(deletedBrandDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ////////////////MODEL////////////////

    @GetMapping(value= "/model/{id}", produces = "application/json")
    public ResponseEntity<ModelDTO> getModel(@PathVariable("id") long id){

        ModelDTO modelDTO = myStorage.getModel(id);

        if (modelDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        modelDTO.add(linkTo(methodOn(StandController.class).getModels()).withSelfRel());
        return new ResponseEntity<>(modelDTO,HttpStatus.OK);
    }

    @GetMapping(value="/models", produces = "application/json")
    public ResponseEntity<CollectionModel<ModelDTO>> getModels(){

        Collection<ModelDTO> listModelsDTO = myStorage.getAllModels();
        if(listModelsDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(ModelDTO modelDTO : listModelsDTO){
            modelDTO.add(linkTo(methodOn(StandController.class).getModel(modelDTO.getModelIDDTO())).withSelfRel());
        }
        Link link = linkTo(methodOn(StandController.class).getModels()).withSelfRel();
        CollectionModel<ModelDTO> response = CollectionModel.of(listModelsDTO, link);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value= "/model", consumes= "application/json", produces= "application/json")
    public ResponseEntity<ModelDTO> addModel(@RequestBody ModelDTO modelDTO) {

        ModelDTO addedModelDTO = myStorage.addModel(modelDTO);

        addedModelDTO.add(linkTo(methodOn(StandController.class).getModel(addedModelDTO.getModelIDDTO())).withSelfRel());
        addedModelDTO.add(linkTo(methodOn(StandController.class).getModels()).withRel("ver_todos_models"));
        addedModelDTO.add(linkTo(methodOn(StandController.class).updateModel(addedModelDTO.getModelIDDTO(), modelDTO)).withRel("update"));
        return new ResponseEntity<>(addedModelDTO, HttpStatus.CREATED);
    }

    @PutMapping(value= "/model/update/{id}", consumes = "application/json")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable("id") long id, @RequestBody ModelDTO modelDTO) {

        ModelDTO updatedModelDTO =myStorage.updateModel(modelDTO);

        if ( updatedModelDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        updatedModelDTO.add(linkTo(methodOn(StandController.class).getModel(id)).withSelfRel());
        updatedModelDTO.add(linkTo(methodOn(StandController.class).getModels()).withRel("ver_todos_models"));

        return new ResponseEntity<>( updatedModelDTO, HttpStatus.OK);
    }

    @DeleteMapping(value="/model/delete/{id}")
    public ResponseEntity<ModelDTO> deleteModel(@PathVariable("id") long id){

        ModelDTO deletedModelDTO = myStorage.deleteModel(id);

        if(deletedModelDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
