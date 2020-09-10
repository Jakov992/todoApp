package com.example.todo.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public interface StatisticsService {
    JSONArray getTaskNamePercentageMap();
}
