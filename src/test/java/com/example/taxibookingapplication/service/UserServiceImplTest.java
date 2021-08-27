package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.exception.UserNameAlreadyPresentException;
import com.example.taxibookingapplication.notification.CustomerNotificationServiceImpl;
import com.example.taxibookingapplication.notification.NotificationFactory;
import com.example.taxibookingapplication.notification.NotificationService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Mock
    private NotificationFactory notificationFactory;


    @BeforeEach
    void setup(){
        userService = new UserServiceImpl(userRepository, notificationFactory);
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


    @Test
    void updateAddress() {
        userService.updateAddress(createUser(), "Sunshine Corio st, VIC");
        verify(userRepository).save(any(User.class));
    }


    private User createUser(){
        return User.builder().email("abc").password("222").firstName("Kishor").lastName("Shrestha").gender(Gender.MALE).
                build();
    }

    @Test
    void deleteUserIfExist() {
        when(userRepository.existsById(any(Integer.class))).thenReturn(true);

        userService.deleteUser(1);

        verify(userRepository).deleteById(any(Integer.class));
    }

    @Test
    void cannotDeleteUserIfNotExist(){

        assertThrows(IllegalStateException.class, ()-> userService.deleteUser(1));
        verify(userRepository, never()).deleteById(any(Integer.class));
    }


}