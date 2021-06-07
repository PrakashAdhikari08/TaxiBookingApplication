package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Role;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    public userService(userRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public void registerCustomer(User user) {
//        List<User> users = userRepository.findAll();
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);
    }

    @Override
    public void registerDriver(User user) {
        user.setRole(Role.DRIVER);
        userRepository.save(user);
    }


    public void deleteUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "user with id " + id + " does not exists");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updateAddress(User user, String address) {
        user.setAddress(address);
        userRepository.save(user);
    }
}
