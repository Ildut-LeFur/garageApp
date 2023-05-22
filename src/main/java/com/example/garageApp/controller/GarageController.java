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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class GarageController {

    @Autowired
    private GarageService garageService;

    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    public List<Car> getCar() {
        return garageService.getCars();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cars/{vin}")
    public Car getCar(@PathVariable String vin) {
        return garageService.getCar(vin);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{vin}")
    public void deleteCar(@PathVariable String vin) {
        garageService.deleteCar(vin);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void addCar(@RequestBody Car car) {
        garageService.addCar(car);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{vin}")
    public void updateCar(@RequestBody Car car,@PathVariable String vin) {
        garageService.updateCar(car, vin);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @RequestMapping("/resource")
    public Map<String,Object> home() {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
    
}
