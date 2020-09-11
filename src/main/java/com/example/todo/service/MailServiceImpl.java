package com.example.todo.service;

import com.example.todo.model.Mail;
import com.example.todo.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    MailRepository mailRepository;

    @Override
    public Mail getNewMail() {
        Mail mail = new Mail();
        return mail;
    }

    @Override
    public void saveMail(Mail mail) {
        mailRepository.save(mail);
    }
}
