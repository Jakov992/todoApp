package com.example.todo.service;

import com.example.todo.model.Mail;
import com.example.todo.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    MailRepository mailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    Environment environment;

    @Override
    public Mail getNewMail() {
        return new Mail();
    }

    @Override
    public void saveMail(Mail mail) {
        mail.setReceiver(environment.getProperty("spring.mail.username"));
        mailRepository.save(mail);
    }

    @Override
    public void sendSimpleMessage(String from, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        String mailReceiver = environment.getProperty("spring.mail.username");
        assert mailReceiver != null;
        message.setTo(mailReceiver);
        message.setSubject(subject);
        message.setText("This message was sent by: " + from + "\n\n\n" + text);
        emailSender.send(message);
    }
}
