package com.example.taxibookingapplication.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DriverNotificationServiceImpl implements NotificationService{

    @Override
    public void sendBookingMessage(String message, String emailID, String name) {
        log.info(message);
      log.info("Booking made for name {} and emailID {}",name, emailID);
    }

    @Override
    public void sendCancelMessage(String message, String emailID, String name) {
        log.info(message);
        log.info("Booking cancel for name {} and emailID {}",name, emailID);
    }
}
