package com.nmr.Repository;

import com.nmr.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public Customer createCustomer(Customer customer) {
        return null;
    }
}
