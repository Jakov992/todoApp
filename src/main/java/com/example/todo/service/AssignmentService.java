package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.Todo;

import java.util.List;
import java.util.Map;

public interface AssignmentService {
    List<Task> getAllTasks();
    Task getNewTask();
    Task getTaskById(long id);
    void saveTask(Task task);
    void deleteTask(Task task);
    List<Todo> getAllTodosFromTask(Task task);
    Todo getNewTodo();
    void saveTodo(Todo todo, Long taskId);
    Todo getTodoById(long id);
    void deleteTodo(Todo todo);
    void saveCheckbox(long todoId, boolean isChecked);
    Map<Long, Integer> getPercentageOfTaskMap();
}
