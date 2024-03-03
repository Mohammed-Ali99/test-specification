package com.spring.testspecificatio.service;

import com.spring.testspecificatio.model.Customer;
import com.spring.testspecificatio.model.CustomerSearch;
import com.spring.testspecificatio.repo.CustomerRepo;
import com.spring.testspecificatio.repo.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public List<Customer> findByCustomerName(CustomerSearch search) {

        CustomerSpecification spec = new CustomerSpecification(search);
        return customerRepo.findAll(spec);
    }

}
