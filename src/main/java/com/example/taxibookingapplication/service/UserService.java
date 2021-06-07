package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.User;

import java.util.List;

public interface UserService {

    void updateAddress(final User user, final String address);

    void deleteUser(Integer id);

    List<User> findAll();

    void registerCustomer(User user);

    void registerDriver(User user);
}