package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.domain.TaxiBooking;
import com.example.taxibookingapplication.exception.TaxiBookingIdNotFoundException;
import com.example.taxibookingapplication.mapper.TaxiBookingMapper;
import com.example.taxibookingapplication.mapper.TaxiMapper;
import com.example.taxibookingapplication.service.TaxiBookingService;
import com.example.taxibookingapplication.service.TaxiBookingServiceImpl;
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
    @RequestMapping(value="/book", method = RequestMethod.GET)
    public ResponseEntity<String> bookAtaxi(
            @RequestParam Integer taxiID, @RequestParam Integer customerID){

       taxiBookingService.bookATaxi(taxiID, customerID);
       return new ResponseEntity<>("Taxi processed for booking", HttpStatus.OK);
    }

    @ApiOperation("Booking Accept information")
    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    public ResponseEntity<String> accepAtaxi(@RequestParam Integer taxiBookingID){
        taxiBookingService.acceptATaxi(taxiBookingID);
        return new ResponseEntity<>("Taxi cancelled", HttpStatus.OK);
    }

    @ApiOperation("Booking Cancel information")
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public ResponseEntity<String> cancelTaxi(@RequestParam Integer taxiBookingID){
        taxiBookingService.cancelTaxi(taxiBookingID);
        return new ResponseEntity<>("Taxi cancelled", HttpStatus.OK);
    }

    @ApiOperation("Booking Complete information")
    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    public ResponseEntity<String> completeTaxi(@RequestParam Integer taxiBookingID) {
        taxiBookingService.completeTaxi(taxiBookingID);
        return new ResponseEntity<>("Taxi Booking Completed", HttpStatus.OK);
    }


    @ExceptionHandler(TaxiBookingIdNotFoundException.class)
    public ResponseEntity<String> taxiBookingNotFound(){
        return new ResponseEntity("Taxi Booking not found", HttpStatus.NOT_FOUND);
    }

}
