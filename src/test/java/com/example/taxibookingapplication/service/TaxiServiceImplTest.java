package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.Status;
import com.example.taxibookingapplication.domain.Taxi;
import com.example.taxibookingapplication.domain.Type;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.TaxiRepository;
import com.example.taxibookingapplication.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaxiServiceImplTest {

    @Autowired
    private TaxiServiceImpl taxiService;

    @Mock
    private TaxiRepository taxiRepository;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        taxiService = new TaxiServiceImpl(taxiRepository, userRepository );
    }

    @Test
    void findAll() {
        taxiService.findAll();
        verify(taxiRepository, times(1)).findAll();

    }

    @Test
    void registerTaxi() {
        Taxi taxi = createTaxi();

        taxiService.registerTaxi(taxi, 1);

        verify(taxiRepository, times(1)).save(taxi);
    }

    @Test
    void getAllAvailable() {

    }

    @Test
    void getAllOccupied() {
    }

    @Test
    void bookTaxi() {
    }

    @Test
    void cancelTaxi() {
    }

    private Taxi createTaxi(){
        return Taxi.builder().taxiNumber("12345").type(Type.MINI).status(Status.AVAILABLE).build();
    }

    private User createUser(){
        return User.builder().email("abc").password("222").firstName("Kishor").lastName("Shrestha").gender(Gender.MALE).
                build();
    }

}
