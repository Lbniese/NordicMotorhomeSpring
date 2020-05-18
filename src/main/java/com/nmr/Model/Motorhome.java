package com.nmr.Model;

public class Motorhome {
    private int id;
    private String brand;
    private String model;
    private int odometer;
    private String size;
    private String type;
    private int pricePerDay;
    private String serviceNotes;

    public Motorhome() {
    }

    public Motorhome(int id, String brand, String model, int odometer, String size, String type, int pricePerDay, String serviceNotes) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.odometer = odometer;
        this.size = size;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.serviceNotes = serviceNotes;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getServiceNotes() {
        return serviceNotes;
    }

    public void setServiceNotes(String serviceNotes) {
        this.serviceNotes = serviceNotes;
    }
}
