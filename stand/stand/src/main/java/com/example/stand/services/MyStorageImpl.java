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
import jakarta.transaction.Transactional;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyStorageImpl implements MyStorage {

    private final VehicleRepository vehicleStorage;
    private final ClientRepository clientStorage;
    private final BrandRepository brandStorage;
    private final ModelRepository modelStorage;


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
            return null;
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
    public Collection<VehicleDTO> getAllVehicles() {
        return vehicleStorage.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
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
    public VehicleDTO deleteVehicle(long id) {

        Vehicle vehicle = vehicleStorage.findById(id).orElse(null);

        if (vehicle != null) {

            vehicleStorage.deleteById(id);


            return convertToDTO(vehicle);
        } else {
            return null;
        }
    }

    @Override
    public VehicleDTO buyVehicle(VehicleDTO vehicleDTO, ClientDTO clientDTO) {

        VehicleDTO updatedVehicleDTO = updateAsSold(vehicleDTO);

        if(updatedVehicleDTO != null && clientDTO != null){
            Optional<Client> optionalClient = clientStorage.findById(clientDTO.getClientIDDTO());

            if(!optionalClient.isPresent()){
                return null;
            }
            updatedVehicleDTO.setClient(client);
        }
        return updatedVehicleDTO;
    }

    @Override
    public VehicleDTO updateAsSold(VehicleDTO vehicleDTO) {

        Optional<Vehicle> optionalVehicle = vehicleStorage.findById(vehicleDTO.getVehicleIdDTO());

        if(!optionalVehicle.isPresent()){
            return null;
        }
        Vehicle vehicle = optionalVehicle.get();

        vehicle.setVehicleStatus(Status.SOLD);

        Vehicle updatedVehicle = vehicleStorage.save(vehicle);

        return convertToDTO(updatedVehicle);
    }

    @Override
    public Collection<VehicleDTO> getVehiclesStock() {
        return vehicleStorage.findAll().stream()
                .filter(vehicle -> vehicle.getVehicleStatus() == Status.IN_STOCK)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<VehicleDTO> getVehiclesSold() {
        return vehicleStorage.findAll().stream()
                .filter(vehicle -> vehicle.getVehicleStatus() == Status.SOLD)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Collection<VehicleDTO> getVehiclesByClient(Client clientId) {
        return vehicleStorage.findAll().stream()
                .filter(vehicle -> vehicle.getClient().equals(clientId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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
    public Collection<ClientDTO> getAllClients() {
        return clientStorage.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
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
    public Collection<BrandDTO> getAllBrands() {
        return brandStorage.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDTO addBrand(BrandDTO brandDTO) {

        Brand brand = new Brand();

        brand.setBrandName(brandDTO.getBrandNameDTO());


        Brand savedBrand = brandStorage.save(brand);

        return convertToDTO(savedBrand);
    }

    @Override
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
    public Collection<ModelDTO> getAllModels() {
        return modelStorage.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModelDTO addModel(ModelDTO modelDTO) {

        Model model = new Model();

        model.setModelName(modelDTO.getModelNameDTO());


        Model savedModel = modelStorage.save(model);

        return convertToDTO(savedModel);
    }

    @Override
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
