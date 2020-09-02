package com.example.todo.controller;

import com.example.todo.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("taskList", assignmentService.getAllTasks());
        return "index";
    }

    @GetMapping("/addNewTask")
    public String getAddNewEmployeeForm(Model model) {
        model.addAttribute("task", assignmentService.getNewTask());
        return "save_task";
    }

    @GetMapping("/updateTask")
    public String showFormUpdate(@RequestParam(name = "id") Long taskId, Model model) {
        model.addAttribute("task", assignmentService.getTaskById(taskId));
        return "save_task";
    }
}
