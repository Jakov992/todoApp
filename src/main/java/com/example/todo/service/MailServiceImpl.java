package com.example.todo.service;

import com.example.todo.model.Mail;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    @Override
    public Mail getNewMail() {
        Mail mail = new Mail();
        return mail;
    }
}
