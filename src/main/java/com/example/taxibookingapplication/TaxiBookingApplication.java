package com.example.taxibookingapplication;

import com.example.taxibookingapplication.config.userconfig.LoadAdminFromFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableAsync
public class TaxiBookingApplication {


   public static void main(String[] args) throws IOException {
        SpringApplication.run(TaxiBookingApplication.class, args);

    }

    @Bean
    public RestTemplate getRestTemplate (){
       return new RestTemplate();
    }

}
