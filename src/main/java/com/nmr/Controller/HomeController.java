package com.nmr.Controller;

import com.nmr.Model.Customer;
import com.nmr.Model.Employee;
import com.nmr.Model.Motorhome;
import com.nmr.Service.CustomerService;
import com.nmr.Service.EmployeeService;
import com.nmr.Service.MotorhomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MotorhomeService motorhomeService;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/customer")
    public String customer(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customer";
    }

    @PostMapping("/customer")
    public String customer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        boolean deleted = customerService.deleteCustomer(id);
        if (deleted) {
            return "redirect:/customer";
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping("/updatecustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "home/updatecustomer";
    }

    @PostMapping("/customer/updatecustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getId(), customer);
        return "redirect:/customer";
    }


    @GetMapping("/employee")
    public String employee(Model model) {
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "home/employee";
    }

    @PostMapping("/employee")
    public String employee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteemployee/{id}")
    public String deleteEmployeer(@PathVariable("id") int id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return "redirect:/employee";
        } else {
            return "redirect:/employee";
        }
    }

    @GetMapping("/updateemployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        return "home/updateemployee";
    }

    @PostMapping("/employee/updateemployee")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/employee";
    }

    @GetMapping("/motorhome")
    public String motorhome(Model model) {
        List<Motorhome> motorhomeList = motorhomeService.fetchAll();
        model.addAttribute("motorhomes", motorhomeList);
        return "home/motorhome";
    }

    @PostMapping("/motorhome")
    public String motorhome(@ModelAttribute Motorhome motorhome) {
        motorhomeService.createMotorhome(motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/deletemotorhome/{id}")
    public String deleteMotorhome(@PathVariable("id") int id) {
        boolean deleted = motorhomeService.deleteMotorhome(id);
        if (deleted) {
            return "redirect:/motorhome";
        } else {
            return "redirect:/motorhome";
        }
    }

    @GetMapping("/updatemotorhome/{id")
    public String updateMotorhome(@PathVariable("id") int id, Model model) {
        model.addAttribute("motorhome", employeeService.findEmployeeById(id));
        return "home/updatemotorhome";
    }

    @PostMapping("/motorhome/updatemotorhome")
    public String updateMotorhome(@ModelAttribute Motorhome motorhome) {
        motorhomeService.updateMotorhome(motorhome.getId(), motorhome);
        return "redirect:/motorhome";
    }

}
