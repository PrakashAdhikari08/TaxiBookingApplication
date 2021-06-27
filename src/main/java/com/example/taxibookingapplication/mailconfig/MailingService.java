package com.example.taxibookingapplication.mailconfig;

import com.example.taxibookingapplication.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Configuration
@Slf4j
public class MailingService {


    @Autowired
    JavaMailSender mailSender;

    @Async
    public void sendEmail(String to, String subject, String mailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cubermanga@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(mailMessage);
        log.info("sending email to : {}", to);
        mailSender.send(message);
    }


}
