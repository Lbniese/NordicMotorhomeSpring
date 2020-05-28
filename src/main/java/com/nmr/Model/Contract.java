package com.nmr.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rentalStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rentalEndDate;
    private String pickUpPoint;
    private String dropOffPoint;
    private String miscellaneous;
    private int customerId;
    private int motorhomeId;
    private int employeeId;
    private double fullPrice;
    private double pickUpPrice;
    private double dropOffPrice;
    private int pickUpKm;
    private int dropOffKm;
    private int bikeRack;
    private int bedLinen;
    private int childSeat;
    private int picnicTable;
    private int chairs;
    private int grill;
    private int lantern;
    private int firstAidKit = 0;
    private int toiletPaper;


    public Contract() {
    }

    public Contract(int id, LocalDateTime rentalStartDate, LocalDateTime rentalEndDate, String pickUpPoint, String dropOffPoint, String miscellaneous, int customerId, int motorhomeId, int employeeId) {
        this.id = id;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
        this.miscellaneous = miscellaneous;
        this.customerId = customerId;
        this.motorhomeId = motorhomeId;
        this.employeeId = employeeId;
    }

    public int getBikeRack() {
        return bikeRack;
    }

    public void setBikeRack(int bikeRack) {
        this.bikeRack = bikeRack;
    }

    public int getBedLinen() {
        return bedLinen;
    }

    public void setBedLinen(int bedLinen) {
        this.bedLinen = bedLinen;
    }

    public int getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(int childSeat) {
        this.childSeat = childSeat;
    }

    public int getPicnicTable() {
        return picnicTable;
    }

    public void setPicnicTable(int picnicTable) {
        this.picnicTable = picnicTable;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getGrill() {
        return grill;
    }

    public void setGrill(int grill) {
        this.grill = grill;
    }

    public int getLantern() {
        return lantern;
    }

    public void setLantern(int lantern) {
        this.lantern = lantern;
    }

    public int getFirstAidKit() {
        return firstAidKit;
    }

    public void setFirstAidKit(int firstAidKit) {
        this.firstAidKit = firstAidKit;
    }

    public int getToiletPaper() {
        return toiletPaper;
    }

    public void setToiletPaper(int toiletPaper) {
        this.toiletPaper = toiletPaper;
    }

    public double getPickUpPrice() {
        return pickUpPrice;
    }

    public void setPickUpPrice(double pickUpPrice) {
        this.pickUpPrice = pickUpPrice;
    }

    public double getDropOffPrice() {
        return dropOffPrice;
    }

    public void setDropOffPrice(double dropOffPrice) {
        this.dropOffPrice = dropOffPrice;
    }

    public int getPickUpKm() {
        return pickUpKm;
    }

    public void setPickUpKm(int pickUpKm) {
        this.pickUpKm = pickUpKm;
    }

    public int getDropOffKm() {
        return dropOffKm;
    }

    public void setDropOffKm(int dropOffKm) {
        this.dropOffKm = dropOffKm;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDateTime RentalStartDate) {
        this.rentalStartDate = RentalStartDate;
    }

    public LocalDateTime getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDateTime rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(String pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public String getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(String dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    public String getMiscellaneous() {
        return miscellaneous;
    }

    public void setMiscellaneous(String miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMotorhomeId() {
        return motorhomeId;
    }

    public void setMotorhomeId(int motorhomeId) {
        this.motorhomeId = motorhomeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}

