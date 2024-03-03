package com.spring.testspecificatio.controller;

import com.spring.testspecificatio.model.Customer;
import com.spring.testspecificatio.model.CustomerSearch;
import com.spring.testspecificatio.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


    @PostMapping("/spec")
    public List<Customer> findByCustomerName(@RequestBody CustomerSearch search) {
        return customerService.findByCustomerName(search);
    }

}
