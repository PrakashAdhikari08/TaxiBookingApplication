package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.service.TaxiBookingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/taxi/book")
public class TaxiBookingController {

    @Autowired
    private TaxiBookingService taxiBookingService;

    @ApiOperation("Booking Status information")
    @RequestMapping(value="/accept", method = RequestMethod.GET)
    public String acceptAtaxi(
            @RequestParam Integer taxiID, @RequestParam Integer customerID){
       taxiBookingService.acceptATaxi(taxiID, customerID);
       return "Taxi processed for booking";
    }

    @ApiOperation("Booking Cancel information")
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancelTaxi(@RequestParam Integer taxiID, @RequestParam Integer customerID){
        taxiBookingService.cancelTaxi(taxiID, customerID);
        return "Taxi cancelled";
    }


}
