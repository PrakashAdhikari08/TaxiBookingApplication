package com.example.taxibookingapplication.service;

public interface TaxiBookingService {
    void acceptATaxi(Integer taxiID, Integer customerID);

    void cancelTaxi(Integer taxiBookingID);

    void completeTaxi(Integer taxiBookingID);
}
