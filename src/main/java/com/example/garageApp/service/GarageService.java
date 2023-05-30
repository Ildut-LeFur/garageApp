package com.example.garageApp.service;

import com.example.garageApp.model.Car;
import com.example.garageApp.repository.GarageRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GarageService {
    
    @Autowired
    private GarageRepository garageRepository;


    
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();
        garageRepository.findAll().forEach(car -> {
            cars.add(car);
        });
        return cars;
    }

    public Car getCar(String vin) {
        return garageRepository.findByVin(vin).get(0);
    }

    public void deleteCar(String vin) {
        garageRepository.deleteByVin(vin);
    }

    public void addCar(Car car) {
        garageRepository.save(car);
    }

    public void editCar(Car car, String vin) {
        garageRepository.deleteByVin(vin);
        garageRepository.save(car);
    }

}
