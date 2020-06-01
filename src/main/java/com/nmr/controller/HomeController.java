package com.nmr.controller;

import com.nmr.handler.PriceHandler;
import com.nmr.model.Contract;
import com.nmr.model.Customer;
import com.nmr.model.Employee;
import com.nmr.model.Motorhome;
import com.nmr.service.ContractService;
import com.nmr.service.CustomerService;
import com.nmr.service.EmployeeService;
import com.nmr.service.MotorhomeService;
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

    /*
    Get- and Postmapping is reused in every method in the homecontroller. Therefore, a global note is written for all mappings below.

    GetMapping: handles the HTTP (Hyper Text Transfer Protocol) "GET" request which is matched with the given URL expression.
    This means, it is used when u want to SHOW information.

    PostMapping: handles the HTTP "POST" request which is matched with the given URL expression.
    This means, it is used when u want to WRITE information.

   @Get- PostMapping is a shortcut for: @RequestMapping(method = RequestMethod.GET/POST)
    */

    /**
     * This is the method for the homepage.
     * It is using Getmapping with the parameter "/". This means the html page will return to first page, which is index, when used.
     * The method returns:
     *
     * @return "home/index"
     * Home is the directory where the html index lies within.
     */

    @GetMapping("/")
    public String index() {
        return "home/index";
    }


    /**
     * Defines the path with "/customer"
     *
     * @param model gets the list of customers.
     * @return "home/customer"
     */

    @GetMapping("/customer")
    public String customer(Model model) {
        //Takes and show the customer list by using the fetch all method in the customerService class.
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);
        return "home/customer";
    }


    /**
     * Defines the path with "/customer".
     *
     * @param customer gets the object as parameter.
     *                 Call the create customer method from the customer service class.
     * @return "redirect:/customer".
     */
    @PostMapping("/customer")
    public String customer(@ModelAttribute Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }


    /**
     * Defines the path with "/deletecustomer/{id}
     *
     * @param id
     * @return "direct:/customer"
     */

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

        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customers", customerList);

        List<Motorhome> motorhomeList = motorhomeService.fetchAll();
        model.addAttribute("motorhomes", motorhomeList);

        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);

        model.addAttribute("localDateTime", LocalDateTime.now());

        return "home/contract";


    }

    @PostMapping("/contract")
    public String contract(@RequestParam("rentalStartDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime rentalStartDate,
                           @RequestParam("rentalEndDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime rentalEndDate,
                           @ModelAttribute Contract contract, Model model) {
        boolean created = contractService.createContract(contract);
        if (created) {
            return "redirect:/contract";
        } else {
            model.addAttribute("message", "Error: Either the start date or end date is overlapping with an existing contract for the selected vehicle.");
            List<Contract> contractList = contractService.fetchAll();
            model.addAttribute("contracts", contractList);
            return "home/contract";
        }
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

    @GetMapping("/cancelcontract/{id}")
    public String cancelContract(@PathVariable("id") int id) {
        boolean canceled = contractService.cancelContract(id);
        if (canceled) {
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
    public String invoice() {
        return "home/invoice";
    }

    @GetMapping("/invoice/{id}")
    public String invoice(@PathVariable("id") int id, Model model) {
        Contract contract = contractService.findContractById(id);
        Motorhome motorhome = motorhomeService.findMotorhomeById(contract.getMotorhomeId());
        Employee employee = employeeService.findEmployeeById(contract.getEmployeeId());
        contract = contractService.calculateFullPrice(contract, motorhome);
        contract = contractService.calculatePickUpAndDropOff(contract);
        model.addAttribute("contract", contract);
        model.addAttribute("customer", customerService.findCustomerById(contract.getCustomerId()));
        model.addAttribute("motorhome", motorhome);
        model.addAttribute("employee", employee);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("addDiscount", PriceHandler.calculateCancellationFee(contract.isActive(), contract.getRentalStartDate()));
        return "home/invoice";
    }

    @GetMapping("/extras")
    public String extras() {
        return "home/extras";
    }

}
