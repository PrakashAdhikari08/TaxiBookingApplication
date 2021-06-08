package com.example.taxibookingapplication.controller;


import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.dto.TaxiDto;
import com.example.taxibookingapplication.mapper.TaxiMapper;
import com.example.taxibookingapplication.mapper.UserMapper;
import com.example.taxibookingapplication.service.TaxiService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi/v1")
public class TaxiController {

    @Autowired
    private TaxiService taxiService;



    @ApiOperation("Save a taxi to the System")
    @RequestMapping(
            value = "/save/{userID}",
            name = "hello from taxi",
            method = RequestMethod.POST,
            consumes = "application/json")

    public ResponseEntity<String> registerTaxi(@RequestBody TaxiDto taxiDto, @PathVariable Integer userID) {
        Taxi taxi = new Taxi();
        taxiService.registerTaxi(taxi, userID);
        return new ResponseEntity<>("Taxi registered", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TaxiDto>> getAllTaxi() {
        List<Taxi> taxis = taxiService.findAll();
        List<TaxiDto> taxiDtoList = TaxiMapper.toTaxiDtoList(taxis);
        return new ResponseEntity<>(taxiDtoList, HttpStatus.CONTINUE);
    }

    @RequestMapping(value = "/all/available", method = RequestMethod.GET)
    public ResponseEntity<List<TaxiDto> >getAllAvailableTaxi(){
        List<Taxi> taxiList = taxiService.getAllAvailable();
        List<TaxiDto> taxiDtoList = TaxiMapper.toTaxiDtoList(taxiList);
        return new ResponseEntity<>(taxiDtoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/all/occupied", method = RequestMethod.GET)
    public ResponseEntity<List<TaxiDto>> getAllOccupiedTaxi() {
        List<Taxi> taxiList = taxiService.getAllOccupied();
        List<TaxiDto> taxiDtoList = TaxiMapper.toTaxiDtoList(taxiList);
        return new ResponseEntity<>(taxiDtoList, HttpStatus.OK);
    }

//    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
//    public String bookTaxi(@PathVariable Integer id){
//        String number= taxiService.bookTaxi(id);
//        return "Taxi booked with taxi number "+ number;
//    }
//
//    @RequestMapping(value = "/cancel/{id}",method = RequestMethod.GET)
//    public String cancelTaxi(@PathVariable Integer id){
//        String taxiNumber = taxiService.cancelTaxi(id);
//        return "Taxi booking cancelled for taxi "+ taxiNumber;
//    }


}
