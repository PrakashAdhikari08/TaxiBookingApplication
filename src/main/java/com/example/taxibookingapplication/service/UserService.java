package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public userService(userRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public void registerUser(User user) {
//        List<User> users = userRepository.findAll();
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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void updateAddress(final User user, final String address) {
        user.setAddress(address);
        userRepository.save(user);
    }
}
