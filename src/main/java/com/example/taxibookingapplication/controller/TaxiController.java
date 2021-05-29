package com.example.taxibookingapplication.controller;


import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.repo.TaxiRepository;
import com.example.taxibookingapplication.service.TaxiService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi/v1")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;

    @ApiOperation("Save a taxi to the System")
    @RequestMapping(
            value = "/save",
            name = "hello from taxi",
            method = RequestMethod.POST,
            consumes = "application/json")

    public String registerTaxi(@RequestBody Taxi taxi) {
        taxiService.registerTaxi(taxi);
        return "Taxi registered";
    }

    @GetMapping(value = "/all")
    public List<Taxi> getAllTaxi() {
        List<Taxi> taxis = taxiService.findAll();
        return taxis;
    }

    @RequestMapping(value = "/all/available", method = RequestMethod.GET)
    public List<Taxi> getAllAvailableTaxi(){
        List<Taxi> taxiList = taxiService.getAllAvailable();
        return taxiList;
    }

    @RequestMapping(value = "/all/occupied", method = RequestMethod.GET)
    public List<Taxi> getAllOccupiedTaxi() {
        List<Taxi> taxiList = taxiService.getAllOccupied();
        return taxiList;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String bookTaxi(@PathVariable Integer id){
        String number= taxiService.bookTaxi(id);
        return "Taxi booked with taxi number "+ number;
    }

    @RequestMapping(value = "/cancel/{id}",method = RequestMethod.GET)
    public String cancelTaxi(@PathVariable Integer id){
        String license = taxiService.cancelTaxi(id);
        return "Taxi booking cancelled for taxi"+ license;
    }


}
