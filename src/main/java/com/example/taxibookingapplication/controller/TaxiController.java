package com.example.taxibookingapplication.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxi/v1")
public class TaxiController {

    @ApiOperation("Greeting from the taxi application")
    @RequestMapping(
            value = "/hello",
            name = "hello from taxi",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String hello(){
        return "HEllo Taxi";
    }
}
