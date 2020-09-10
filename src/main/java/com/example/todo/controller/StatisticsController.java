package com.example.todo.controller;

import ch.qos.logback.core.pattern.util.IEscapeUtil;
import com.example.todo.service.AssignmentService;
import com.example.todo.service.StatisticsService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Controller
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/statistics")
    public String viewStatistics(Model model) {
        JSONArray jsonArray = statisticsService.getTaskNamePercentageMap();
        System.out.println(jsonArray);
        model.addAttribute("taskNamePercentageMap", jsonArray);
        return "statistics/main";
    }
}
