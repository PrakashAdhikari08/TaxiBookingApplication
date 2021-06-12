package com.example.taxibookingapplication.notification;

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
    public void sendBookingMessage(String message, String emailID, String name) {
        log.info("Customer Notification");
        mailingService.sendEmail("gaurabkarki1@gmail.com", "Booking Made", message);
    }

    @Override
    public void sendCancelMessage(String message, String emailID, String name) {

    }
}
