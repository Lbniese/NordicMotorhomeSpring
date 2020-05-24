package com.nmr.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    private int id;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;
    private String pickUpPoint;
    private String dropOffPoint;
    private String miscellaneous;
    private int customerId;
    private int motorhomeId;
    private int employeeId;

    public Contract() {
    }

    public Contract(int id, LocalDateTime startDate, LocalDateTime endDate, String pickUpPoint, String dropOffPoint, String miscellaneous, int customerId, int motorhomeId, int employeeId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pickUpPoint = pickUpPoint;
        this.dropOffPoint = dropOffPoint;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setFromDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setToDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

