package com.nmr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity annotation specifies that the class is an entity and is mapped to a database table.
 * Id annotation specifies the primary key for the table.
 */
@Entity
public class Employee {
    /**
     * Fields
     */
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String address;
    private String phoneNumber;
    private String email;
    private String zipCode;
    private String city;
    private String country;

    /**
     * Empty Constructor
     */
    public Employee() {
    }

    /**
     * Default Constructor
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param title
     * @param address
     * @param phoneNumber
     * @param email
     * @param zipCode
     * @param city
     * @param country
     */
    public Employee(int id, String firstName, String lastName, String title, String address, String phoneNumber, String email, String zipCode, String city, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    /**
     * Getters & Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
