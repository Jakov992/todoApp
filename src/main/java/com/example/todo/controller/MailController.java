package com.example.todo.controller;

import com.example.todo.model.Mail;
import com.example.todo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {

    @Autowired
    MailService mailService;


    @GetMapping("/sendingMailForm")
    public String sendingMailForm(Model model) {
        model.addAttribute("mail", mailService.getNewMail());
        return "sendingMail/mail_form";
    }

    @PostMapping("/sendMail")
    public String sendMail(@ModelAttribute Mail mail) {
        mailService.saveMail(mail);
        mailService.sendSimpleMessage(mail.getSender(), mail.getSubject(), mail.getContent());
        return "redirect:/sendingMailForm";
    }
}
