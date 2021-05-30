package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.domain.Customer;
import com.example.taxibookingapplication.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("Customer registration")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String customerRegister(@RequestBody Customer customer){
        customerService.registerCustomer(customer);
        return "Customer registered";
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Customer> showAll(){
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "Customer Deleted";
    }

    @PutMapping(value = "/update")
    public String updateAddress(final Customer customer, String address){
        customerService.updateAddress(customer,address);
        return "Customer Details Updated";
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> noUserFound(){
        return new ResponseEntity<>("NO user found" , HttpStatus.BAD_REQUEST);
    }
}
