package com.example.stand.services;

import com.example.stand.dto.BrandDTO;
import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.ModelDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.enums.Status;
import com.example.stand.models.Brand;
import com.example.stand.models.Client;
import com.example.stand.models.Model;
import com.example.stand.models.Vehicle;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MyStorageImpl implements MyStorage {

    @Autowired
    VehicleRepository vehicleStorage;

    @Autowired
    ClientRepository clientStorage;

    @Autowired
    BrandRepository brandStorage;

    @Autowired
    ModelRepository modelStorage;


    public MyStorageImpl(VehicleRepository vehicleStorage, ClientRepository clientStorage, BrandRepository brandStorage, ModelRepository modelStorage) {
        this.vehicleStorage = vehicleStorage;
        this.clientStorage = clientStorage;
        this.brandStorage = brandStorage;
        this.modelStorage = modelStorage;
    }

    @Override
    public VehicleDTO getVehicle(long id) {
        Vehicle vehicle = vehicleStorage.findById(id).orElse(null);
        if (vehicle == null) {
            throw new EntityNotFoundException("Vehicle with id" + id + "was not found!");
        }
        return convertToDTO(vehicle);
    }

    private VehicleDTO convertToDTO(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getVehicleID(),
                vehicle.getVehicleName(),
                vehicle.getVehicleLicensePlate(),
                vehicle.getVehicleNumberSeats(),
                vehicle.getVehicleNumberDoors(),
                vehicle.getVehicleTraction(),
                vehicle.getVehicleFuel(),
                vehicle.getVehicleColor(),
                vehicle.getVehicleType(),
                vehicle.getVehicleStatus(),
                vehicle.getClient(),
                vehicle.getModel()
        );
    }

    @Override
    public Page<VehicleDTO> getAllVehicles(int page, int size, String sort) {
        return vehicleStorage.findAll(PageRequest.of(page, size, Sort.by(sort))).map(this::convertToDTO);
    }

    @Override
    @Transactional
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleName(vehicleDTO.getVehicleNameDTO());
        vehicle.setVehicleLicensePlate(vehicleDTO.getVehicleLicensePlateDTO());
        vehicle.setVehicleNumberSeats(vehicleDTO.getVehicleNumberSeatsDTO());
        vehicle.setVehicleNumberDoors(vehicleDTO.getVehicleNumberDoorsDTO());
        vehicle.setVehicleTraction(vehicleDTO.getVehicleTractionDTO());
        vehicle.setVehicleFuel(vehicleDTO.getVehicleFuelDTO());
        vehicle.setVehicleColor(vehicleDTO.getVehicleColorDTO());
        vehicle.setVehicleType(vehicleDTO.getVehicleTypeDTO());
        vehicle.setVehicleStatus(vehicleDTO.getVehicleStatusDTO());
        vehicle.setClient(vehicleDTO.getClient());
        vehicle.setModel(vehicleDTO.getModel());

        Vehicle savedVehicle = vehicleStorage.save(vehicle);

        return convertToDTO(savedVehicle);
    }

    @Override
    @Transactional
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {

        if(!vehicleStorage.existsById(vehicleDTO.getVehicleIdDTO())){
            return null;
        }
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleName(vehicleDTO.getVehicleNameDTO());
        vehicle.setVehicleLicensePlate(vehicleDTO.getVehicleLicensePlateDTO());
        vehicle.setVehicleNumberSeats(vehicleDTO.getVehicleNumberSeatsDTO());
        vehicle.setVehicleNumberDoors(vehicleDTO.getVehicleNumberDoorsDTO());
        vehicle.setVehicleTraction(vehicleDTO.getVehicleTractionDTO());
        vehicle.setVehicleFuel(vehicleDTO.getVehicleFuelDTO());
        vehicle.setVehicleColor(vehicleDTO.getVehicleColorDTO());
        vehicle.setVehicleType(vehicleDTO.getVehicleTypeDTO());
        vehicle.setVehicleStatus(vehicleDTO.getVehicleStatusDTO());
        vehicle.setClient(vehicleDTO.getClient());
        vehicle.setModel(vehicleDTO.getModel());

        Vehicle updatedVehicle = vehicleStorage.save(vehicle);

        return convertToDTO(updatedVehicle);
    }

    @Override
    @Transactional
    public VehicleDTO deleteVehicle(long id) {

        Vehicle vehicle = vehicleStorage.findById(id).orElse(null);

        if (vehicle != null) {

            vehicleStorage.deleteById(id);

            return convertToDTO(vehicle);

        } else {
            throw new EntityNotFoundException("Vehicle with id" + id + "not found!");
        }
    }

    @Override
    @Transactional
    public VehicleDTO buyVehicle(long vehicleId, long clientId, long transactionId) {

        VehicleDTO updatedVehicleDTO = updateAsSold(vehicleId);

        if(updatedVehicleDTO != null ){
            Optional<Client> optionalClient = clientStorage.findById(clientId);

            if(!optionalClient.isPresent()){
                return null;
            }
            Client client = optionalClient.get();

            updatedVehicleDTO.setClient(client);
            updatedVehicleDTO.setTransactionId(transactionId);
        }else{
            return null;
        }
        return updatedVehicleDTO;
    }

    @Override
    @Transactional
    public int updateVehicleStatus(long vehicleId, Status newStatus) {
        Vehicle vehicle = vehicleStorage.findVehicleStatus(vehicleId);

        if(vehicle != null){
            vehicle.setVehicleStatus(newStatus);
            vehicleStorage.save(vehicle);
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    @Transactional
    public VehicleDTO updateAsSold(long id) {

        Optional<Vehicle> optionalVehicle = vehicleStorage.findById(id);

        if(!optionalVehicle.isPresent()){
            return null;
        }
        Vehicle vehicle = optionalVehicle.get();

        vehicle.setVehicleStatus(Status.SOLD);

        Vehicle updatedVehicle = vehicleStorage.save(vehicle);

        return convertToDTO(updatedVehicle);
    }

    @Override
    public Page<VehicleDTO> getVehiclesStock(int page, int size, String sort) {
        Page<Vehicle> stockVehicles = vehicleStorage.findVehiclesByStatus(Status.STOCK, Pageable.unpaged());
        return stockVehicles.map(this::convertToDTO);
    }


    @Override
    public Page<VehicleDTO> getVehiclesSold(int page, int size, String sort) {
        Page<Vehicle> soldVehicles = vehicleStorage.findVehiclesByStatus(Status.SOLD, Pageable.unpaged());
        return soldVehicles.map(this::convertToDTO);
    }

    @Override
    @Transactional
    public Page<VehicleDTO> getVehiclesByClient(long clientId, int page, int size, String sort) {
        Page<Vehicle> vehiclesByClientId = vehicleStorage.findByClientId(clientId, Pageable.unpaged());
        return vehiclesByClientId.map(this::convertToDTO);
    }



    ////////////////CLIENT//////

    @Override
    public ClientDTO getClient(long id) {
        Client client = clientStorage.findById(id).orElse(null);

        if (client == null) {
            return null;
        }
        return convertToDTO(client);
    }

    private ClientDTO convertToDTO(Client client) {
        return new ClientDTO(
                client.getClientID(),
                client.getClientName(),
                client.getClientAddress(),
                client.getClientPhoneNumber(),
                client.getClientNif(),
                client.getClientEmailAddress(),
                client.getStand()
        );
    }

    @Override
    public Page<ClientDTO> getAllClients(int page, int size, String sort) {
        return clientStorage.findAll(PageRequest.of(page, size, Sort.by(sort)))
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public ClientDTO addClient(ClientDTO clientDTO) {

        Client client = new Client();

        client.setClientName(clientDTO.getClientNameDTO());
        client.setClientAddress(clientDTO.getClientAddressDTO());
        client.setClientPhoneNumber(clientDTO.getClientPhoneNumberDTO());
        client.setClientNif(clientDTO.getClientNifDTO());
        client.setClientEmailAddress(clientDTO.getClientEmailAddressDTO());
        client.setStand(clientDTO.getStandDTO());


        Client savedClient = clientStorage.save(client);

        return convertToDTO(savedClient);
    }

    @Override
    @Transactional
    public ClientDTO updateClient(ClientDTO clientDTO) {

        if(!clientStorage.existsById(clientDTO.getClientIDDTO())){
            return null;
        }
        Client client = new Client();

        client.setClientName(clientDTO.getClientNameDTO());
        client.setClientAddress(clientDTO.getClientAddressDTO());
        client.setClientPhoneNumber(clientDTO.getClientPhoneNumberDTO());
        client.setClientNif(clientDTO.getClientNifDTO());
        client.setClientEmailAddress(clientDTO.getClientEmailAddressDTO());
        client.setStand(clientDTO.getStandDTO());


        Client updatedClient = clientStorage.save(client);

        return convertToDTO(updatedClient);
    }

    @Override
    @Transactional
    public ClientDTO deleteClient(long id) {

        Client client = clientStorage.findById(id).orElse(null);

        if (client != null) {

            clientStorage.deleteById(id);


            return convertToDTO(client);
        } else {
            return null;
        }
    }

    ////////////BRAND////////

    @Override
    public BrandDTO getBrand(long id) {

        Brand brand = brandStorage.findById(id).orElse(null);

        if (brand == null) {
            return null;
        }
        return convertToDTO(brand);
    }

    private BrandDTO convertToDTO(Brand brand) {
        return new BrandDTO(
                brand.getBrandID(),
                brand.getBrandName()
        );
    }

    @Override
    public Page<BrandDTO> getAllBrands(int page, int size) {
        return brandStorage.findAll(PageRequest.of(page,size))
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public BrandDTO addBrand(BrandDTO brandDTO) {

        Brand brand = new Brand();

        brand.setBrandName(brandDTO.getBrandNameDTO());


        Brand savedBrand = brandStorage.save(brand);

        return convertToDTO(savedBrand);
    }

    @Override
    @Transactional
    public BrandDTO updateBrand(BrandDTO brandDTO) {

        if(!brandStorage.existsById(brandDTO.getBrandIDDTO())){
            return null;
        }
        Brand brand = new Brand();

        brand.setBrandName(brandDTO.getBrandNameDTO());

        Brand updatedBrand = brandStorage.save(brand);

        return convertToDTO(updatedBrand);
    }

    @Override
    @Transactional
    public BrandDTO deleteBrand(long id) {

        Brand brand = brandStorage.findById(id).orElse(null);

        if (brand != null) {

            brandStorage.deleteById(id);


            return convertToDTO(brand);
        } else {
            return null;
        }
    }

    //////////MODEL////////


    @Override
    public ModelDTO getModel(long id) {

        Model model = modelStorage.findById(id).orElse(null);

        if (model == null) {
            return null;
        }
        return convertToDTO(model);
    }

    private ModelDTO convertToDTO(Model model) {
        return new ModelDTO(
                model.getModelID(),
                model.getModelName()
        );
    }

    @Override
    @Transactional
    public Page<ModelDTO> getAllModels(int page, int size) {
        return modelStorage.findAll(PageRequest.of(page,size))
                .map(this::convertToDTO);
    }

    @Override
    @Transactional
    public ModelDTO addModel(ModelDTO modelDTO) {

        Model model = new Model();

        model.setModelName(modelDTO.getModelNameDTO());


        Model savedModel = modelStorage.save(model);

        return convertToDTO(savedModel);
    }

    @Override
    @Transactional
    public ModelDTO updateModel(ModelDTO modelDTO) {

        if(!modelStorage.existsById(modelDTO.getModelIDDTO())){
            return null;
        }
        Model model = new Model();

        model.setModelName(modelDTO.getModelNameDTO());

        Model updatedModel = modelStorage.save(model);

        return convertToDTO(updatedModel);
    }

    @Override
    @Transactional
    public ModelDTO deleteModel(long id) {

        Model model = modelStorage.findById(id).orElse(null);

        if (model != null) {

            modelStorage.deleteById(id);


            return convertToDTO(model);
        } else {
            return null;
        }
    }


}
