package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.Todo;

import java.util.List;

public interface AssignmentService {
    List<Task> getAllTasks();
    Task getNewTask();
    Task getTaskById(long id);
    void saveTask(Task task);
    List<Todo> getAllTodosFromTask(Task task);
    Todo getNewTodo();
    void saveTodo(Todo todo, Long taskId);
}
