package com.example.todo.service;

import com.example.todo.model.Mail;

public interface MailService {
    Mail getNewMail();
    void saveMail(Mail mail);
    void sendSimpleMessage(String to, String subject, String text);
}
