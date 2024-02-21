package com.example.stand.services;

import com.example.stand.enums.Status;
import com.example.stand.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//    @Query("SELECT v FROM Vehicle v WHERE v.BusinessStatus = :businessStatus")
//    List<Vehicle> findByStatus(BusinessStatus businessStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.client.clientID = :clientId")
    Page<Vehicle> findByClientId(long clientId, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.vehicleStatus = :status")
    Page<Vehicle> findVehiclesByStatus(@Param("status") Status status, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.vehicleID = :vehicleId") //nao precisava de ter feito isto
    Vehicle findVehicleStatus(@Param("vehicleId")long vehicleId);

}
