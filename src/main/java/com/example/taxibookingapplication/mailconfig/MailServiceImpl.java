package com.example.taxibookingapplication.mailconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailServiceImpl {


    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cubermanga@gmail.com");
        message.setTo("gaurabkarki1@gmail.com");
        message.setSubject("Hi");
        message.setText("Hello");
        mailSender.send(message);
    }
}
