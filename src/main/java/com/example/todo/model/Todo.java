package com.example.todo.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Todo extends Task {

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "isChecked=" + isChecked +
                '}';
    }
}
