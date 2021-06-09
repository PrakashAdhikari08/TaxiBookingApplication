package com.example.taxibookingapplication.config.userconfig;

import com.example.taxibookingapplication.domain.Gender;
import com.example.taxibookingapplication.domain.Role;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

@Service
@Slf4j
public class LoadAdminFromFile {
    @Autowired
    private UserRepository userRepository;

    public void loadAdmin() throws IOException {

        File file = new File("loadAdmin.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(",");

            User user = new User();

            user.setFirstName(line[0]);
            user.setLastName(line[1]);
            user.setAddress(line[2]);
            user.setBirthDate(LocalDate.parse(line[3]));
            user.setGender(Gender.valueOf(line[4]));
            user.setEmail(line[5]);
            user.setPassword(line[6]);
            user.setRole(Role.valueOf(line[7]));
            user.setResetToken(generateResetToken());

            userRepository.save(user);
            log.info("User with username : {} and role : {} saved to DB", user.getEmail(), user.getRole());
        }
    }


    private Integer generateResetToken() {
        Random random = new Random();
        int number = random.nextInt(999999);

        return Integer.valueOf(String.format("%06d", number));
    }
}
