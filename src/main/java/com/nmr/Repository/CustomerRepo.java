package com.nmr.Repository;

import com.nmr.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (firstName, lastName, phoneNumber, email, address, driverLicenceNumber, zipCode) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber(), customer.getEmail(), customer.getAddress(), customer.getDriverLicenceNumber(), customer.getZipCode());
        return null;
    }

    public List<Customer> fetchAll() {
        String sql = "SELECT * FROM Customer c JOIN Zipcode z ON c.zipCode = z.zipCode";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }
}
