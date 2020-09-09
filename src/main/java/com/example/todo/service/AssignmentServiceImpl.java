package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.TaskTodo;
import com.example.todo.model.Todo;
import com.example.todo.repository.TaskRepository;
import com.example.todo.repository.TaskTodoRepository;
import com.example.todo.repository.TodoRepository;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
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

    @Override
    public Task getNewTask() {
        Task task = new Task();
        return task;
    }

    @Override
    public Task getTaskById(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = null;
        if(optionalTask.isPresent()) {
            task = optionalTask.get();
        } else {
            throw new RuntimeException("Task not found for id: " + id);
        }
        return task;
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Todo> getAllTodosFromTask(Task task) {
        List<Todo> todoList = new ArrayList<Todo>();
        Set<TaskTodo> taskTodoSet = task.taskTodoSet;
        for (TaskTodo taskTodo : taskTodoSet) {
            todoList.add(taskTodo.getTodo());
        }
        Collections.sort(todoList);
        todoList.removeIf(todo -> todo.isDeleted());
        return todoList;
    }

    @Override
    public Todo getNewTodo() {
        Todo todo = new Todo();
        return todo;
    }

    @Override
    public void saveTodo(Todo todo, Long taskId) {
        todo = todoRepository.save(todo);
        saveTaskTodo(todo, taskId);
    }

    private void saveTaskTodo(Todo todo, Long taskId) {
        TaskTodo taskTodo = taskTodoRepository.findByTaskIdAndTodoId(taskId, todo.getId());
        if(taskTodo == null) {
            Task task = getTaskById(taskId);
            taskTodo = new TaskTodo(task, todo);
            taskTodoRepository.save(taskTodo);
        }
    }

    @Override
    public Todo getTodoById(long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todo = null;
        if(optionalTodo.isPresent()) {
            todo = optionalTodo.get();
        } else {
            throw new RuntimeException("Todo not found for id: " + id);
        }
        return todo;
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepository.deleteTodoById(todo.getId());
    }
}
