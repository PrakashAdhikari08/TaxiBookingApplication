package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.exception.TaxiBookingIdNotFoundException;
import com.example.taxibookingapplication.service.TaxiBookingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String cancelTaxi(@RequestParam Integer taxiBookingID){
        taxiBookingService.cancelTaxi(taxiBookingID);
        return "Taxi cancelled";
    }

    @ApiOperation("Booking Complete information")
    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    public String completeTaxi(@RequestParam Integer taxiBookingID) {
        taxiBookingService.completeTaxi(taxiBookingID);
        return "Taxi Booking Completed";
    }


    @ExceptionHandler(TaxiBookingIdNotFoundException.class)
    public ResponseEntity<String> taxiBookingNotFound(){
        return new ResponseEntity("Taxi Booking not found", HttpStatus.NOT_FOUND);
    }

}
