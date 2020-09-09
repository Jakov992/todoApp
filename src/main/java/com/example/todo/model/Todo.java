package com.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Todo extends Assignment implements Comparable<Todo> {

    private boolean isChecked;

    @OneToMany(mappedBy = "todo")
    Set<TaskTodo> taskTodoSet;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Todo todo) {
        if(this.getId() > todo.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
