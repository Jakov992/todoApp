package com.example.todo.service;

import com.example.todo.model.Mail;
import com.example.todo.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    MailRepository mailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public Mail getNewMail() {
        Mail mail = new Mail();
        return mail;
    }

    @Override
    public void saveMail(Mail mail) {
        mailRepository.save(mail);
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("todoAppJakov992@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
