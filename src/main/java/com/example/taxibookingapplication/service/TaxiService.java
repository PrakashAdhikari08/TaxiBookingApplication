package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Taxi;

import java.util.List;

public interface TaxiService {
    void registerTaxi(Taxi taxi, Integer userID);

    List<Taxi> findAll();

    List<Taxi> getAllAvailable();

    String cancelTaxi(Integer id);

    String bookTaxi(Integer id);

    List<Taxi> getAllOccupied();
}
