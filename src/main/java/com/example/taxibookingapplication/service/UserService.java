package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.exception.UserNameAlreadyPresentException;

import java.util.List;

public interface UserService {

    void updateAddress(final User user, final String address);

    void deleteUser(Integer id);

    List<User> findAll();

    String registerCustomer(User user) throws UserNameAlreadyPresentException;

    void registerDriver(User user);
}
