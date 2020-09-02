package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.repository.TaskTodoRepository;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TaskTodoRepository taskTodoRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
