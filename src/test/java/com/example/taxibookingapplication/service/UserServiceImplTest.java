package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.exception.UserNameAlreadyPresentException;
import com.example.taxibookingapplication.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void failRegisteringAlreadyRegisteredUser() {
        when(userRepository.countByEmail("abc")).thenReturn((long) 1);
        assertThrows(UserNameAlreadyPresentException.class, ()-> userService.registerCustomer(createUser()));
    }

    @Test
    void registerUserWithUniqueUserName() throws UserNameAlreadyPresentException {
        when(userRepository.countByEmail("abc")).thenReturn((long) 0);
        assertDoesNotThrow(() -> userService.registerCustomer(createUser()));

        userService.registerCustomer(createUser());

        verify(userRepository, times(2)).save(any(User.class));
    }

    @Test
    void registerDriverSuccessfully(){
        userService.registerDriver(createUser());

        verify(userRepository).save(any(User.class));
    }

    private User createUser(){
        return User.builder().email("abc").password("222").
                build();
    }

}