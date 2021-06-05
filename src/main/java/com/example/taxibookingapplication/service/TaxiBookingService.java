package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.*;
import com.example.taxibookingapplication.exception.TaxiBookingIdNotFoundException;
import com.example.taxibookingapplication.repo.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private TaxiBookingRepository taxiBookingRepository;

    public void acceptATaxi(Integer taxiId, Integer customerID) {
        if (taxiRepository.existsById(taxiId)) {
            Taxi taxi = taxiRepository.getById(taxiId);
            if (taxi.getStatus() == Status.AVAILABLE) {
                taxi.setStatus(Status.OCCUPIED);
//            taxiRepository.save(taxi);
                User user = userRepository.getById(customerID);
//            customerRepository.save(customer);
                TaxiBooking taxiBooking = new TaxiBooking();
                taxiBooking.setUser(user);
                taxiBooking.setTaxi(taxi);
                taxiBooking.setTaxiBookingStatus(BookingStatus.ACTIVE);

                taxiBookingRepository.save(taxiBooking);
            } else
                throw getTaxiBookingIdNotFoundException(taxiId);
        } else
            throw getTaxiBookingIdNotFoundException(taxiId);


    }

    public void cancelTaxi(Integer taxiBookingID) throws TaxiBookingIdNotFoundException {
        if (taxiBookingRepository.existsById(taxiBookingID)) {
            TaxiBooking taxiBooking = taxiBookingRepository.findById(taxiBookingID).get();

            Taxi taxi = taxiRepository.getById(taxiBooking.getTaxi().getId());
            if (taxi.getStatus() == Status.OCCUPIED) {
                taxi.setStatus(Status.AVAILABLE);
                taxiRepository.save(taxi);
//           taxiBookingRepository.getTaxiBookingByCustomerAndTaxiId(taxiID, customerID);
                taxiBooking.setTaxiBookingStatus(BookingStatus.CANCEL);
                taxiBookingRepository.save(taxiBooking);
            } else
                throw getTaxiBookingIdNotFoundException(taxiBookingID);
        } else {
            throw getTaxiBookingIdNotFoundException(taxiBookingID);
        }

    }

    private TaxiBookingIdNotFoundException getTaxiBookingIdNotFoundException(Integer taxiBookingId) {
        return new TaxiBookingIdNotFoundException("Taxi Booking Id " + taxiBookingId + " Not Found");
    }

    public void completeTaxi(Integer taxiBookingID) throws RuntimeException {
        TaxiBooking taxiBooking = taxiBookingRepository.findById(taxiBookingID).get();
        Taxi taxi = taxiRepository.findById(taxiBooking.getTaxi().getId()).get();
        if (taxiBooking.getTaxiBookingStatus() == BookingStatus.ACTIVE) {
            taxiBooking.setTaxiBookingStatus(BookingStatus.COMPLETE);
            taxi.setStatus(Status.AVAILABLE);
            taxiRepository.save(taxi);
            taxiBookingRepository.save(taxiBooking);
        } else {
            throw new RuntimeException("Booking already Completed");

        }

    }
}
