package com.example.todo.controller;

import com.example.todo.model.Mail;
import com.example.todo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String sendMail(@ModelAttribute Mail mail,
                           RedirectAttributes redirectAttributes) {
        mailService.saveMail(mail);
        mailService.sendSimpleMessage(mail.getSender(), mail.getSubject(), mail.getContent());
        redirectAttributes.addFlashAttribute("message", "Mail successfuly sent!");
        return "redirect:/sendingMailForm";
    }
}
