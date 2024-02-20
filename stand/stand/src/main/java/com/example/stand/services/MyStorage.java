package com.example.stand.services;

import com.example.stand.dto.BrandDTO;
import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.ModelDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.enums.Status;
import com.example.stand.models.Brand;
import com.example.stand.models.Client;

import java.util.Collection;

public interface MyStorage {

    public VehicleDTO getVehicle(long id);

    public Collection<VehicleDTO> getAllVehicles();

    public VehicleDTO addVehicle(VehicleDTO vehicle);

    public VehicleDTO updateVehicle(VehicleDTO vehicle);

    public VehicleDTO deleteVehicle(long id);

    public VehicleDTO buyVehicle(long vehicleId, long clientId, long transactionId);
    public int updateVehicleStatus(long vehicleId, Status newStatus);
    public VehicleDTO updateAsSold(long vehicleId);
    public Collection<VehicleDTO> getVehiclesStock();
    public Collection<VehicleDTO> getVehiclesSold();
    public Collection<VehicleDTO> getVehiclesByClient(long clientId);

    ///////////////////////////

    public ClientDTO getClient(long id);

    public Collection<ClientDTO> getAllClients();

    public ClientDTO addClient(ClientDTO client);

    public ClientDTO updateClient(ClientDTO client);

    public ClientDTO deleteClient(long id);


    //////////////

    public BrandDTO getBrand(long id);

    public Collection<BrandDTO> getAllBrands();

    public BrandDTO addBrand(BrandDTO brand);

    public BrandDTO updateBrand(BrandDTO brand);

    public BrandDTO deleteBrand(long id);

    ///////////////////

    public ModelDTO getModel(long id);

    public Collection<ModelDTO> getAllModels();

    public ModelDTO addModel(ModelDTO model);

    public ModelDTO updateModel(ModelDTO model);

    public ModelDTO deleteModel(long id);



}
