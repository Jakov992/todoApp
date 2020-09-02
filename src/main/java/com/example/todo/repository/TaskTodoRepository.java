package com.example.todo.repository;

import com.example.todo.model.Task;
import com.example.todo.model.TaskTodo;
import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskTodoRepository extends JpaRepository<TaskTodo, Long> {

}
