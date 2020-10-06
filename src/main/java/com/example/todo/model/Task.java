package com.example.todo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task extends Assignment {

    private String description;

    @OneToMany(mappedBy = "task")
    public
    Set<TaskTodo> taskTodoSet;

    public Task(String name) {
        this.setName(name);
    }

    public Task(String name, String description) {
        this.setName(name);
        this.description = description;
    }

    @Override
    public String toString() {
        return getName();
    }
}
