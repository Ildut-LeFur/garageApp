package com.example.garageApp.repository;

import com.example.garageApp.model.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends CrudRepository<Car, Long>{
    
}
