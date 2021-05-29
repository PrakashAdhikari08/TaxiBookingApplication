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

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public long count(){
        return customerRepository.count();
    }

    public void delete(Customer customer){
        customerRepository.delete(customer);
    }

    public void save (Customer customer){
        if(customer == null){
            LOGGER.info( "Customer is null, Are you sure you want to to submit yur application");
            return;
        }
        customerRepository.save(customer);
    }
}
