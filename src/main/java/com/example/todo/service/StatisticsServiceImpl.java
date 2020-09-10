package com.example.todo.service;

import com.example.todo.model.Task;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private AssignmentService assignmentService;

    @Override
    public JSONArray getTaskNamePercentageMap(){

        Map<String, Integer> taskNamePercentageMap = new LinkedHashMap<String, Integer>();

        List<Task> taskList = assignmentService.getAllTasks();
        Map<Long, Integer> percentageOfTaskMap = assignmentService.getPercentageOfTaskMap();
        JSONArray array = new JSONArray();

        for (Task task : taskList) {
            try {
                JSONObject aaa = new JSONObject();
                aaa.put("name", task.getName());
                aaa.put("low", percentageOfTaskMap.get(task.getId()));
                array.put(aaa);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return array;
    }
}
