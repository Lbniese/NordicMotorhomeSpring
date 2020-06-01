package com.nmr.service;

import com.nmr.model.Employee;
import com.nmr.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee createEmployee(Employee employee) {
        return employeeRepo.createEmployee(employee);
    }

    public List<Employee> fetchAll() {
        return employeeRepo.fetchAll();
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.findEmployeeById(id);
    }

    public Boolean deleteEmployee(int id) {
        return employeeRepo.deleteEmployee(id);
    }

    public Employee updateEmployee(int id, Employee employee) {
        return employeeRepo.updateEmployee(id, employee);
    }
}
