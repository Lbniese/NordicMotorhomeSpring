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

    /**
     * createCustomer()
     * @param customer
     * @return
     */
    public String createCustomer(Customer customer) {
        try {
            boolean validEmail = customerRepo.emailValidation(customer.getEmail());
            boolean validPhoneNumber = customerRepo.phoneNumberValidation(customer.getPhoneNumber());
            if (!validEmail) {
                return "emailError";
            } else if (!validPhoneNumber) {
                return "phoneNumberError";
            } else {
                customerRepo.createCustomer(customer);
                return "success";
            }
        } catch (DataIntegrityViolationException ex) {
            return "zipError";
        }
    }

    /**
     * fetchAll()
     * @return
     */
    public List<Customer> fetchAll() {
        return customerRepo.fetchAll();
    }

    /**
     * findCustomerById()
     * @param id
     * @return
     */
    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    /**
     * deleteCustomer()
     * @param id
     * @return
     */
    public Boolean deleteCustomer(int id) {
        try {
            return customerRepo.deleteCustomer(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    /**
     * updateCustomer()
     * @param id
     * @param customer
     * @return
     */
    public Customer updateCustomer(int id, Customer customer) {
        return customerRepo.updateCustomer(id, customer);
    }

}
