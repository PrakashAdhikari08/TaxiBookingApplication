package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.domain.Customer;
import com.example.taxibookingapplication.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
