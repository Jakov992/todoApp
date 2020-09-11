package com.example.todo.controller;

import com.example.todo.service.MailService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/sendingMailForm")
    public String sendingMailForm(Model model) {
        model.addAttribute("mail", mailService.getNewMail());
        return "sendingMail/mail_form";
    }
}
