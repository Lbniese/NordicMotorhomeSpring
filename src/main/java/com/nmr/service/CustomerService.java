package com.nmr.service;

import com.nmr.model.Customer;
import com.nmr.repository.CustomerRepo;
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

    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    public Customer updateCustomer(int id, Customer customer) {
        return customerRepo.updateCustomer(id, customer);
    }

}