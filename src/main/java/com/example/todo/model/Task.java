package com.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Task extends Assignment {

    private String description;

    @OneToMany(mappedBy = "task")
    Set<TaskTodo> taskTodoSet;

    public Task() {}

    public Task(String name) {
        this.setName(name);
    }

    public Task(String name, String description) {
        this.setName(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
