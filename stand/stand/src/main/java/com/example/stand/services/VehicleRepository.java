package com.example.stand.services;

import com.example.stand.enums.Status;
import com.example.stand.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//    @Query("SELECT v FROM Vehicle v WHERE v.BusinessStatus = :businessStatus")
//    List<Vehicle> findByStatus(BusinessStatus businessStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.client.clientID = :clientId")
    Collection<Vehicle> findByClientId(long clientId);

    @Query("SELECT v FROM Vehicle v WHERE v.vehicleStatus = :status")
    Collection<Vehicle> findVehiclesByStatus(@Param("status") Status status);

    @Modifying
    @Query("UPDATE Vehicle v SET v.vehicleStatus = :newStatus WHERE v.vehicleID = :vehicleId ")
    int updateVehicleStatus(@Param("vehicleId")long vehicleId, @Param("newStatus") Status newStatus);

}
