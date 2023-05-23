// package com.example.garageApp.repository;

// import java.util.List;

// import com.example.garageApp.model.Car;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;

// interface CustomizedGarageRepository {
//     void deleteByVin(String vin);

//     public List<Car> findByVin(String vin);
//   }

// class CustomizedGarageRepositoryImpl implements CustomizedGarageRepository {

//   @PersistenceContext
//   private EntityManager entityManager;


//   public void deleteByVin(String vin) {
//       this.entityManager.getTransaction().begin();
//       this.entityManager.createQuery("DELETE FROM Car c WHERE c.vin LIKE :VIN").setParameter("VIN", vin).executeUpdate();
//       this.entityManager.getTransaction().commit();
//   }
//   public List<Car> findByVin(String vin) {
//       // entityManager.getTransaction().begin();
//       // entityManager.getTransaction().commit();
//       return this.entityManager.createQuery("SELECT c FROM Car c WHERE c.vin LIKE :VIN")
//           .setParameter("VIN", vin).getResultList();
//   }
// }
