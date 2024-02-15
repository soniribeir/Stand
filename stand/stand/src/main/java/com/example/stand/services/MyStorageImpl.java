package com.example.stand.services;

import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.VehicleDTO;
import com.example.stand.models.Vehicle;

import java.util.Collection;
import java.util.Map;

public class MyStorageImpl implements MyStorage {

    Map<String, VehicleDTO> vehicleStorage;
    Map<String, ClientDTO> clientStorage;

    public MyStorageImpl(Map<String, VehicleDTO> vehicleStorage, Map<String, ClientDTO> clientStorage) {
        this.vehicleStorage = vehicleStorage;
        this.clientStorage = clientStorage;
    }

    @Override
    public VehicleDTO getVehicle(String name) {
        return vehicleStorage.get(name);
    }

    @Override
    public Collection<VehicleDTO> getAllVehicles() {
        return vehicleStorage.values();
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicle) {
        return vehicleStorage.put(vehicle.getVehicleNameDTO(), vehicle);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicle) {
        return vehicleStorage.put(vehicle.getVehicleNameDTO(), vehicle);
    }

    @Override
    public ClientDTO getClient(String name) {
        return clientStorage.get(name);
    }

    @Override
    public Collection<ClientDTO> getAllClients() {
        return clientStorage.values();
    }

    @Override
    public ClientDTO addClient(ClientDTO client) {
        return clientStorage.put(client.getClientNameDTO(), client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO client) {
        return clientStorage.put(client.getClientNameDTO(), client);
    }
}
