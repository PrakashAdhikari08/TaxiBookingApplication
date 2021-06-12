package com.example.taxibookingapplication.mailconfig;

public class MessageGenerator {

    public static String generateBookingMessageForCustomer(String customerName, String taxiNumber, String driverName) {
        return "Dear " + customerName + ",\n" + "Thank you for Booking with us. \n" + "Your Taxi Details: \n" +
                "Taxi Number : " + taxiNumber + "\n Driver Name : " + driverName + " \n \n Regards, \n The Booking Team";
    }

    public static String generateCancelMessageForCustomer( String customerName, String taxiNumber) {
        return "Dear " + customerName + ",\n" + "Your booking for taxi number: " + taxiNumber + " has been cancelled"+ " \n \n Regards, \n The Booking Team";
    }

    public static String generateBookingMessageForDriver(String driverName, String customerName) {
        return "Dear " + driverName+ ",\n" + "Your taxi has been booked for " + customerName+ ".\n Regards \n The Team";
    }

    public static String generateCancelMessageForDriver(String driverName, String customerName) {
        return "Dear " + driverName+ ",\n" + "Your taxi has been cancelled for " + customerName+ ".\n Regards \n The Team";
    }

    public static String registerCustomerMessage(String customerName){
        return "Dear " + customerName + ","+"\n" + "Welcome to the Team and thank your for using the service." + " \n \n Regards, \n The Booking Team";
    }
}
