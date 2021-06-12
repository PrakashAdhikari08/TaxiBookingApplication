package com.example.taxibookingapplication.notification;

import com.example.taxibookingapplication.mailconfig.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationFactory {

   @Autowired
   private CustomerNotificationServiceImpl customerNotificationService;

   @Autowired
   private DriverNotificationServiceImpl driverNotificationService;

    public void configureBooking(String message, String emailID, String name, Integer type){
        if( type == 1 )
            customerNotificationService.sendBookingMessage(message, emailID, name);
        else
            driverNotificationService.sendBookingMessage(message, emailID, name);
    }

    public void registerCustomerFirsttime( String emailId, String name, String message){
        customerNotificationService.sendRegisterMessage(emailId,name,message);
    }


}
