package com.example.todo.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @GetMapping("/sendingMailForm")
    public String sendingMailForm(Model model) {
        return "sendingMail/mail_form";
    }
}
