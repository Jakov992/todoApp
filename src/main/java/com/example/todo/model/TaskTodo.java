package com.example.todo.model;

import javax.persistence.*;

@Entity
public class TaskTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    Todo todo;

    public TaskTodo() {} // JPA konvencija je da svaki Entity ima defaultni konstruktor(isto tako svaki field mora imat gettere i settere)

    public TaskTodo(Task task, Todo todo) {
        this.task = task;
        this.todo = todo;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
