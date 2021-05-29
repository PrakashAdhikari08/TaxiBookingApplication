package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Customer;
import com.example.taxibookingapplication.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public void registerCustomer(Customer customer) {
//        List<Customer> customers = customerRepository.findAll();
        customerRepository.save(customer);

    }
}
