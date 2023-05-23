package com.example.garageApp.controller;

import com.example.garageApp.model.Car;
import com.example.garageApp.service.GarageService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public void updateCar(@RequestBody Car car,@PathVariable String vin) {
        garageService.updateCar(car, vin);
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @GetMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
    
}
