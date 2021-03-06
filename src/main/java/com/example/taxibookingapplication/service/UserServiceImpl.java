package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Role;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.exception.UserNameAlreadyPresentException;
import com.example.taxibookingapplication.mailconfig.MailingService;
import com.example.taxibookingapplication.mailconfig.MessageGenerator;
import com.example.taxibookingapplication.notification.NotificationFactory;
import com.example.taxibookingapplication.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private NotificationFactory notificationFactory;

    public UserServiceImpl(UserRepository userRepository, NotificationFactory notificationFactory) {
        this.userRepository = userRepository;
        this.notificationFactory = notificationFactory;
    }

    public String registerCustomer(User user) throws UserNameAlreadyPresentException {
        if(userRepository.countByEmail(user.getEmail()) >0){
            log.info("Username: already in use.", user.getEmail());
            throw new UserNameAlreadyPresentException("Username already in use");
        }
        user.setResetToken(generateResetToken());
        user.setRole(Role.CUSTOMER);
        log.info("Registering user into DB with name: {} and Role : {}", user.getFirstName(), user.getRole());
        userRepository.save(user);
        log.info(MessageGenerator.registerCustomerMessage(user.getFirstName()));
        notificationFactory.registerCustomerFirsttime(user.getEmail(),user.getFirstName(),MessageGenerator.registerCustomerMessage(user.getFirstName()));
        return "redirect:/registration/success";
    }

    @Override
    public void registerDriver(User user) {
        user.setRole(Role.DRIVER);
        user.setResetToken(generateResetToken());
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void deleteUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "user with id " + id + " does not exists");
        }
        log.info("Deleting user with user id : {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updateAddress(User user, String address) {
        log.info("Updating the address for user: {}", user.getFirstName() );
        user.setAddress(address);
        userRepository.save(user);
    }

    private Integer generateResetToken() {
        Random random = new Random();
        int number = random.nextInt(999999);

        return Integer.valueOf(String.format("%06d", number));
    }
}
