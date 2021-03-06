package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.*;
import com.example.taxibookingapplication.exception.TaxiBookingIdNotFoundException;
import com.example.taxibookingapplication.notification.NotificationFactory;
import com.example.taxibookingapplication.repo.UserRepository;
import com.example.taxibookingapplication.repo.TaxiBookingRepository;
import com.example.taxibookingapplication.repo.TaxiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static com.example.taxibookingapplication.mailconfig.MessageGenerator.*;

@Service
@Slf4j
public class TaxiBookingServiceImpl implements TaxiBookingService{

    @Autowired
    private TaxiRepository taxiRepository;

//    private SendMailService sendMailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationFactory notificationFactory;

    @Autowired
    private TaxiBookingRepository taxiBookingRepository;

    public void bookATaxi(Integer taxiId, Integer customerID) {
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
                taxiBooking.setBookedTime(taxiBooking.getBookedTime());
                taxiBookingRepository.save(taxiBooking);
                notificationFactory.configureBooking(generateBookingMessageForCustomer(user.getFirstName(), taxi.getTaxiNumber(), taxi.getUser().getFirstName()), user.getEmail(), user.getFirstName(), 1);
                notificationFactory.configureBooking(generateBookingMessageForDriver(taxi.getUser().getFirstName(),user.getFirstName()), user.getEmail(), user.getFirstName(), 2);
            } else
                throw getTaxiBookingIdNotFoundException(taxiId);
        } else
            throw getTaxiBookingIdNotFoundException(taxiId);


    }

    public void acceptATaxi(Integer taxiBookingID){
        if(taxiBookingRepository.existsById(taxiBookingID)){
            TaxiBooking taxiBooking = taxiBookingRepository.findById(taxiBookingID).get();
            Taxi taxi = taxiRepository.getById(taxiBooking.getTaxi().getId());
            User user =taxiBookingRepository.getById(taxiBookingID).getUser();

            if (taxiBooking.getTaxiBookingStatus() == BookingStatus.ACTIVE){
                taxiBooking.setAcceptedTime(LocalTime.now());
                taxiBookingRepository.save(taxiBooking);
                notificationFactory.configureBooking(generateAcceptMessageForCustomer(user.getFirstName(),taxi.getTaxiNumber()), user.getEmail(), user.getFirstName(),1);
            }
        }
    }



    public void cancelTaxi(Integer taxiBookingID) throws TaxiBookingIdNotFoundException {
        if (taxiBookingRepository.existsById(taxiBookingID)) {
            TaxiBooking taxiBooking = taxiBookingRepository.findById(taxiBookingID).get();
            log.info(taxiBooking.getUser().getFirstName());
            Taxi taxi = taxiRepository.getById(taxiBooking.getTaxi().getId());
            log.info(String.format(String.valueOf(taxiBooking.getTaxi().getId())));
            if (taxi.getStatus() == Status.OCCUPIED) {
                taxi.setStatus(Status.AVAILABLE);
                taxiRepository.save(taxi);
//           taxiBookingRepository.getTaxiBookingByCustomerAndTaxiId(taxiID, customerID);
                User user =taxiBookingRepository.getById(taxiBookingID).getUser();
                log.info("Username {}",user.getFirstName());
                taxiBooking.setTaxiBookingStatus(BookingStatus.CANCEL);
                taxiBooking.setCancelTime(LocalTime.now());

                taxiBookingRepository.save(taxiBooking);
                notificationFactory.configureBooking(generateCancelMessageForCustomer(user.getFirstName(),taxi.getTaxiNumber()), user.getEmail(), user.getFirstName(),1);

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
            taxiBooking.setEndTime(LocalTime.now());
            taxiRepository.save(taxi);
            taxiBookingRepository.save(taxiBooking);
        } else {
            throw new RuntimeException("Booking already Completed");

        }

    }
}
