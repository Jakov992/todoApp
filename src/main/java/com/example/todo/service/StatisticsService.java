package com.example.todo.service;

import java.util.Map;

public interface StatisticsService {
    Map<String, Integer> getTaskNamePercentageMap();
}
