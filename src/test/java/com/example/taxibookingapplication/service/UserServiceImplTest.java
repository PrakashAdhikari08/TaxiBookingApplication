package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @BeforeEach
    void setup(){
        userService = new UserServiceImpl(userRepository);
    }


    @Test
    void getAllUserTest() {

        userService.findAll();

        verify(userRepository).findAll();
    }

    private User createUser(){
        return User.builder().email("abc").password("222").
                build();
    }

}