package com.nmr.Controller;

import com.nmr.Handler.PriceHandler;
import com.nmr.Model.*;
import com.nmr.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MotorhomeService motorhomeService;

    @Autowired
    ContractService contractService;


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

    @GetMapping("/updatemotorhome/{id}")
    public String updateMotorhome(@PathVariable("id") int id, Model model) {
        model.addAttribute("motorhome", motorhomeService.findMotorhomeById(id));
        return "home/updatemotorhome";
    }

    @PostMapping("/motorhome/updatemotorhome")
    public String updateMotorhome(@ModelAttribute Motorhome motorhome) {
        motorhomeService.updateMotorhome(motorhome.getId(), motorhome);
        return "redirect:/motorhome";
    }

    @GetMapping("/contract")
    public String contract(Model model) {
        List<Contract> contractList = contractService.fetchAll();
        model.addAttribute("contracts", contractList);
        return "home/contract";
    }

    @PostMapping("/contract")
    public String contract(@RequestParam("rentalStartDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime rentalStartDate,
                           @RequestParam("rentalEndDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime rentalEndDate,
                           @ModelAttribute Contract contract) {
        contractService.createContract(contract);
        return "redirect:/contract";
    }

    @GetMapping("/deletecontract/{id}")
    public String deleteContract(@PathVariable("id") int id) {
        boolean deleted = contractService.deleteContract(id);
        if (deleted) {
            return "redirect:/contract";
        } else {
            return "redirect:/contract";
        }
    }

    @GetMapping("/updatecontract/{id}")
    public String updateContract(@PathVariable("id") int id, Model model) {
        model.addAttribute("contract", contractService.findContractById(id));
        return "home/updatecontract";
    }

    @PostMapping("/contract/updatecontract")
    public String updateContract(@ModelAttribute Contract contract) {
        contractService.updateContract(contract.getId(), contract);
        return "redirect:/contract";
    }

    @GetMapping("contract/invoice")
    public String invoice(){
        return "home/invoice";
    }

    @GetMapping("/invoice/{id}")
    public String invoice(@PathVariable("id") int id, Model model) {
        Contract contract = contractService.findContractById(id);
        Motorhome motorhome = motorhomeService.findMotorhomeById(contract.getMotorhomeId());
        contract = contractService.calulateFullPrice(contract, motorhome);
        model.addAttribute("contract", contract);
        model.addAttribute("customer", customerService.findCustomerById(contract.getCustomerId()));
        model.addAttribute("motorhome", motorhome);
        model.addAttribute("localDate", LocalDate.now());
        return "home/invoice";
    }

}
