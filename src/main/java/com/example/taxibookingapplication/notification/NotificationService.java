package com.example.taxibookingapplication.notification;


public interface NotificationService {
    void sendBookingMessage(String message, String emailID, String name);
    void sendCancelMessage(String message, String emailID, String name);

}
