package com.example.garageApp.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class Car {

    public enum Color {
        RED,
        BLUE,
        GREEN,
        YELLOW,
        WHITE,
        GREY,
        BLACK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String model;
    private String brand;
    @Column(name = "released_year")
    private int year;
    private Color color;
    private String vin;

    public Car() {

    }

    public Car(long id, String model, String brand, int year, Color color, String vin) {
        super();
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }

}
