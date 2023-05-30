package com.example.garageApp.controller;

import com.example.garageApp.model.Car;
import com.example.garageApp.service.GarageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class GarageController {

    @Autowired
    private GarageService garageService;

    @GetMapping("/cars")
    public List<Car> getCar() {
        return garageService.getCars();
    }

    @GetMapping("/cars/{vin}")
    public Car getCar(@PathVariable String vin) {
        return garageService.getCar(vin);
    }

    @DeleteMapping("/cars/{vin}")
    public void deleteCar(@PathVariable String vin) {
        garageService.deleteCar(vin);
    }

    @PostMapping("/cars")
    public void addCar(@RequestBody Car car) {
        garageService.addCar(car);
    }

    @PutMapping("/cars/{vin}")
    public void editCar(@RequestBody Car car,@PathVariable String vin) {
        garageService.editCar(car, vin);
    }

}
