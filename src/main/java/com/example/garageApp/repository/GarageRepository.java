package com.example.garageApp.repository;

import com.example.garageApp.model.Car;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GarageRepository extends CrudRepository<Car, Long>{

    @Modifying
    @Query(value = "DELETE FROM Car c WHERE c.vin = :VIN")
    Integer deleteByVin(@Param("VIN") String vin);

    @Query(value = "SELECT c FROM Car c WHERE c.vin = :VIN")
    List<Car> findByVin(@Param("VIN") String vin);
    
}
