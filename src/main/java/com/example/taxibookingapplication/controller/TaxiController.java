package com.example.taxibookingapplication.controller;


import com.example.taxibookingapplication.domain.Taxi;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxi/v1")
public class TaxiController {

    @ApiOperation("Save a taxi to the System")
    @RequestMapping(
            value = "/save",
            name = "hello from taxi",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public String saveTaxi(@RequestBody Taxi taxi){
        return "HEllo Taxi";
    }
}
