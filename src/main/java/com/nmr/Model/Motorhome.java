package com.nmr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Motorhome {
    @Id
    private int id;
    private String brand;
    private String model;
    private int odometer;
    private String vehicleSize;
    private String vehicleType;
    private int pricePerDay;
    private String serviceNote;

    public Motorhome() {
    }

    public Motorhome(int id, String brand, String model, int odometer, String vehicleSize, String vehicleType, int pricePerDay, String serviceNotes) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.odometer = odometer;
        this.vehicleSize = vehicleSize;
        this.vehicleType = vehicleType;
        this.pricePerDay = pricePerDay;
        this.serviceNote = serviceNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String size) {
        this.vehicleSize = size;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(String serviceNote) {
        this.serviceNote = serviceNote;
    }
}
