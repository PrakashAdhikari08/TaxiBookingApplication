package com.example.taxibookingapplication.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerNotificationServiceImpl implements NotificationService {
    @Override
    public void sendBookingMessage(String message, String emailID, String name) {
        log.info("Customer Notification");
    }

    @Override
    public void sendCancelMessage(String message, String emailID, String name) {

    }
}
