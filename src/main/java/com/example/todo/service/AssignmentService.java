package com.example.todo.service;

import com.example.todo.model.Task;

import java.util.List;

public interface AssignmentService {
    List<Task> getAllTasks();
    Task getNewTask();
    Task getTaskById(long id);
    void saveTask(Task task);
}
