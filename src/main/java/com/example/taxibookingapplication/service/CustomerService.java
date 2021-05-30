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

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }


    public void registerCustomer(Customer customer) {
//        List<Customer> customers = customerRepository.findAll();
        customerRepository.save(customer);
    }


    public void deleteCustomer(Integer id) {
        boolean exists = customerRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "customer with id " + id + " does not exists");
        }
        customerRepository.deleteById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
