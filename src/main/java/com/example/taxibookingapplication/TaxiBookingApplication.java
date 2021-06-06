package com.example.taxibookingapplication;

import com.example.taxibookingapplication.config.userconfig.LoadAdminFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication

public class TaxiBookingApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TaxiBookingApplication.class, args);

    }

}
