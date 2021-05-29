package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Customer;
import com.example.taxibookingapplication.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    private Customer customer;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public void registerCustomer(Customer customer) {
//        List<Customer> customers = customerRepository.findAll();
        customerRepository.save(customer);
    }


    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);

    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
