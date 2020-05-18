package com.nmr.Model;


import java.time.LocalDateTime;

public class Contract {
    private int id;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String pickupPoint;
    private String dropoffPoint;
    private String miscellaneous;
    private int customerId;
    private int motorhomeId;
    private int employeeId;

    public Contract() {
    }

    public Contract(int id, LocalDateTime fromDate, LocalDateTime toDate, String pickupPoint, String dropoffPoint, String miscellaneous, int customerId, int motorhomeId, int employeeId) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickupPoint = pickupPoint;
        this.dropoffPoint = dropoffPoint;
        this.miscellaneous = miscellaneous;
        this.customerId = customerId;
        this.motorhomeId = motorhomeId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getDropoffPoint() {
        return dropoffPoint;
    }

    public void setDropoffPoint(String dropoffPoint) {
        this.dropoffPoint = dropoffPoint;
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

