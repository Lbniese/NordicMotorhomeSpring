package com.nmr.Repository;

import com.nmr.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (firstName, lastName, phoneNumber, email, address, driverLicenceNumber, zipCode) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getDriverLicenceNumber(), customer.getZipCode());
        return null;
    }
}
