package com.example.taxibookingapplication.mailconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@Configuration
public class MailingService {


    @Autowired
    JavaMailSender mailSender;

    @Async
    public void sendEmail(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cubermanga@gmail.com");
        message.setTo("gaurabkarki1@gmail.com");
        message.setSubject("Hi");
        message.setText(text);
        mailSender.send(message);
    }
}
