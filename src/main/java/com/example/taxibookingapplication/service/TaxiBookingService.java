package com.example.taxibookingapplication.service;

public interface TaxiBookingService {
    void acceptATaxi(Integer taxiBookingID);

    void cancelTaxi(Integer taxiBookingID);

    void completeTaxi(Integer taxiBookingID);

    void bookATaxi(Integer taxiID, Integer customerID);
}
