package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private AssignmentService assignmentService;

    @Override
    public Map<String, Integer> getTaskNamePercentageMap(){

        Map<String, Integer> taskNamePercentageMap = new HashMap<String, Integer>();

        List<Task> taskList = assignmentService.getAllTasks();
        Map<Long, Integer> percentageOfTaskMap = assignmentService.getPercentageOfTaskMap();

        for (Task task : taskList) {
            taskNamePercentageMap.put(task.getName(), percentageOfTaskMap.get(task.getId()));
        }

        System.out.println(taskNamePercentageMap);

        return taskNamePercentageMap;
    }
}
