package com.example.todo.repository;

import com.example.todo.model.TaskTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTodoRepository extends JpaRepository<TaskTodo, Long> {
}
