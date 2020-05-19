package com.nmr.Service;

import com.nmr.Model.Customer;
import com.nmr.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }
}
