package com.example.stand.services;

import com.example.stand.dto.BrandDTO;
import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.ModelDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.enums.Status;
import com.example.stand.models.Brand;
import com.example.stand.models.Client;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface MyStorage {

    public VehicleDTO getVehicle(long id);

    public Page<VehicleDTO> getAllVehicles(int page, int size, String sort);

    public VehicleDTO addVehicle(VehicleDTO vehicle);

    public VehicleDTO updateVehicle(VehicleDTO vehicle);

    public VehicleDTO deleteVehicle(long id);

    public VehicleDTO buyVehicle(long vehicleId, long clientId, long transactionId);
    public int updateVehicleStatus(long vehicleId, Status newStatus);
    public VehicleDTO updateAsSold(long vehicleId);
    public Page<VehicleDTO> getVehiclesStock(int page, int size, String sort);
    public Page<VehicleDTO> getVehiclesSold(int page, int size, String sort);
    public Page<VehicleDTO> getVehiclesByClient(long clientId, int page, int size, String sort);

    ///////////////////////////

    public ClientDTO getClient(long id);

    public Page<ClientDTO> getAllClients(int page, int size, String sort);

    public ClientDTO addClient(ClientDTO client);

    public ClientDTO updateClient(ClientDTO client);

    public ClientDTO deleteClient(long id);


    //////////////

    public BrandDTO getBrand(long id);

    public Page<BrandDTO> getAllBrands(int page, int size);

    public BrandDTO addBrand(BrandDTO brand);

    public BrandDTO updateBrand(BrandDTO brand);

    public BrandDTO deleteBrand(long id);

    ///////////////////

    public ModelDTO getModel(long id);

    public Page<ModelDTO> getAllModels(int page, int size);

    public ModelDTO addModel(ModelDTO model);

    public ModelDTO updateModel(ModelDTO model);

    public ModelDTO deleteModel(long id);



}
