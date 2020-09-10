package com.example.todo.controller;

import com.example.todo.service.AssignmentService;
import com.example.todo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/statistics")
    public String viewStatistics(Model model) {
        model.addAttribute("taskNamePercentageMap", statisticsService.getTaskNamePercentageMap());
        return "statistics/main";
    }
}
