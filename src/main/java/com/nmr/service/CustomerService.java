package com.nmr.service;

import com.nmr.model.Customer;
import com.nmr.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Boolean createCustomer(Customer customer) {
        try {
            customerRepo.createCustomer(customer);
            return true;
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    public Boolean deleteCustomer(int id) {
        try {
            return customerRepo.deleteCustomer(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public Customer updateCustomer(int id, Customer customer) {
        return customerRepo.updateCustomer(id, customer);
    }

}
