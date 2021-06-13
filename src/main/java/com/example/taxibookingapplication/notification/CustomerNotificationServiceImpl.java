package com.example.taxibookingapplication.notification;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.mailconfig.MailingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerNotificationServiceImpl implements NotificationService {

    @Autowired
    private MailingService mailingService;


    @Override
    public void sendBookingMessage(String emailID, String subject, String message) {
//        log.info("Customer Notification");
        log.info("sending email to {}", emailID);
        mailingService.sendEmail(emailID, "Booking Made", message);
    }

    @Override
    public void sendCancelMessage(String message, String emailID, String name) {

        mailingService.sendEmail("gaurabkarki1@gmail.com" ,"Booking cancelled", message);

    }

    public void sendRegisterMessage(String emailID, String subject, String message){
        log.info("sending email to :{}", emailID);
        mailingService.sendEmail(emailID, "Registration done", message);
    }

    public void sendAcceptMessage(String emailID, String subject, String message) {
//        log.info("Customer Notification");
        log.info("sending email to {}", emailID);
        mailingService.sendEmail(emailID, "Booking Made", message);
    }
}
