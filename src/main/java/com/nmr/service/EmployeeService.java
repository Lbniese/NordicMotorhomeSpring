package com.nmr.service;

import com.nmr.model.Employee;
import com.nmr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    /**
     * createEmployee()
     * @param employee
     * @return
     */
    public String createEmployee(Employee employee) {
        try {
            boolean validEmail = employeeRepo.emailValidation(employee.getEmail());
            boolean validPhoneNumber = employeeRepo.phoneNumberValidation(employee.getPhoneNumber());
            if (!validEmail) {
                return "emailError";
            } else if (!validPhoneNumber) {
                return "phoneNumberError";
            } else {
                employeeRepo.createEmployee(employee);
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
    public List<Employee> fetchAll() {
        return employeeRepo.fetchAll();
    }

    /**
     * findEmployeeById()
     * @param id
     * @return
     */
    public Employee findEmployeeById(int id) {
        return employeeRepo.findEmployeeById(id);
    }

    /**
     * deleteEmployee()
     * @param id
     * @return
     */
    public Boolean deleteEmployee(int id) {
        try {
            return employeeRepo.deleteEmployee(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    /**
     * updateEmployee()
     * @param id
     * @param employee
     * @return
     */
    public Employee updateEmployee(int id, Employee employee) {
        return employeeRepo.updateEmployee(id, employee);
    }
}
