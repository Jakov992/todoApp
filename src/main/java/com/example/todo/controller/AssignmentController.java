package com.example.todo.controller;

import com.example.todo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("taskList", assignmentService.getAllTasks());
        return "index";
    }
}
