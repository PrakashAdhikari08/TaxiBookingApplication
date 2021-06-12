package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.*;
import com.example.taxibookingapplication.dto.TaxiBookingDto;
import com.example.taxibookingapplication.exception.TaxiBookingIdNotFoundException;
import com.example.taxibookingapplication.notification.CustomerNotificationServiceImpl;
import com.example.taxibookingapplication.notification.DriverNotificationServiceImpl;
import com.example.taxibookingapplication.notification.NotificationFactory;
import com.example.taxibookingapplication.notification.NotificationService;
import com.example.taxibookingapplication.repo.UserRepository;
import com.example.taxibookingapplication.repo.TaxiBookingRepository;
import com.example.taxibookingapplication.repo.TaxiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

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
                taxiBooking.setBookedTime(taxiBooking.getBookedTime());
                sendMailService.sendMail(new Mail("Booking created"));
                taxiBookingRepository.save(taxiBooking);
                notificationFactory.configureBooking("ASD", user.getEmail(), user.getFirstName(), 1);
                notificationFactory.configureBooking("ASD", user.getEmail(), user.getFirstName(), 2);
            } else
                throw getTaxiBookingIdNotFoundException(taxiId);
        } else
            throw getTaxiBookingIdNotFoundException(taxiId);


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
                sendMailService.sendMail(new Mail("Booking cancelled"));

                taxiBookingRepository.save(taxiBooking);
                notificationFactory.configureBooking("ASD", user.getEmail(), user.getFirstName(), 1);


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
