package com.nmr.Service;

import com.nmr.Model.Customer;
import com.nmr.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }

    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

}
