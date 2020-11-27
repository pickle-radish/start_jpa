package com.example.jpa.start.jpa.service;

import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final UserRepository repository;

    @Autowired
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "pickleradish0222@gmail.com";

    public void login(String randomNum) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tkdansg0222@gmail.com");
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject("login test");
        message.setText("test for send mail \n your auth number is " + randomNum);

        mailSender.send(message);

    }
}
