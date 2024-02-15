package com.example.stand.services;

import com.example.stand.dto.ClientDTO;
import com.example.stand.dto.VehicleDTO;

import java.util.Collection;

public interface MyStorage {

    public VehicleDTO getVehicle(String name);

    public Collection<VehicleDTO> getAllVehicles();

    public VehicleDTO addVehicle(VehicleDTO vehicle);

    public VehicleDTO updateVehicle(VehicleDTO vehicle);

    public ClientDTO getClient(String name);

    public Collection<ClientDTO> getAllClients();

    public ClientDTO addClient(ClientDTO client);

    public ClientDTO updateClient(ClientDTO client);

}
