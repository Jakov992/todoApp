package com.example.todo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo extends Assignment {

    private boolean isChecked;

    @OneToMany(mappedBy = "todo")
    Set<TaskTodo> taskTodoSet;

    @Override
    public String toString() {
        return getName();
    }
}
