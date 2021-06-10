package com.example.taxibookingapplication.service;

import com.example.taxibookingapplication.domain.Mail;

import javax.mail.MessagingException;

public interface SendMailService {
    void sendMail(Mail mail);

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}

