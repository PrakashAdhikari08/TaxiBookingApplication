package com.example.taxibookingapplication.mailconfig;

public class MessageGenerator {

    public static String generateBookingMessageForCustomer(String customerName, String taxiNumber, String driverName){
        return "Hello " + customerName + ",\n" + "Thank you for Booking with us. \n" + "Your Taxi Details: \n"+
        "Taxi Number : " +taxiNumber + "\n Driver Name : " + driverName +" \n \n Regards, \n The Booking Team";
    }
}
