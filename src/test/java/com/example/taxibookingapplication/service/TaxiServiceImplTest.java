package com.example.taxibookingapplication.service;

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
        verify(taxiRepository.findAll(), times(1));

    }

    @Test
    void registerTaxi() {
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
}