package com.example.garageApp.repository;

import java.util.List;

import com.example.garageApp.model.Car;

import jakarta.persistence.EntityManager;

interface CustomizedGarageRepository {
    void deleteByVin(String vin);

    public List<Car> findByVin(String vin);
  }

class CustomizedGarageRepositoryImpl implements CustomizedGarageRepository {

    private EntityManager entityManager;
    public void deleteByVin(String vin) {
        entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Car c WHERE c.vin LIKE :VIN").setParameter("VIN", vin).executeUpdate();
        entityManager.getTransaction().commit();
    }
    public List<Car> findByVin(String vin) {
        // List<Car> car=null;
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        return this.entityManager.createQuery("SELECT c FROM Car c WHERE c.vin LIKE :VIN")
            .setParameter("VIN", vin).getResultList();
    }
  }
