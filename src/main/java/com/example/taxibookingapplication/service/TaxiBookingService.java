package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.*;
import com.example.taxibookingapplication.repo.CustomerRepository;
import com.example.taxibookingapplication.repo.TaxiBookingRepository;
import com.example.taxibookingapplication.repo.TaxiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaxiBookingService {

    @Autowired
    private TaxiRepository taxiRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TaxiBookingRepository taxiBookingRepository;
    public void acceptATaxi(Integer taxiId, Integer customerID) {
        Taxi taxi = taxiRepository.getById(taxiId);
        if(taxi.getStatus() == Status.AVAILABLE) {
            taxi.setStatus(Status.OCCUPIED);
            taxiRepository.save(taxi);
            Customer customer = customerRepository.getById(customerID);

            TaxiBooking taxiBooking = new TaxiBooking();
            taxiBooking.setCustomer(customer);
            taxiBooking.setTaxi(taxi);
            taxiBooking.setTaxiBookingStatus(BookingStatus.ACTIVE);

            taxiBookingRepository.save(taxiBooking);
        }
        else
            throw new RuntimeException("message");



    }

    public void cancelTaxi(Integer taxiID, Integer customerID) {
        Taxi taxi = taxiRepository.getById(taxiID);
        if(taxi.getStatus()==Status.OCCUPIED) {

            Customer customer = customerRepository.getById(customerID);

            taxi.setStatus(Status.AVAILABLE);
            taxiRepository.save(taxi);
            customerRepository.save(customer);

            TaxiBooking taxiBooking = new TaxiBooking();
            taxiBookingRepository.save(taxiBooking);
        }
        else
            throw new RuntimeException("message");

    }
}
