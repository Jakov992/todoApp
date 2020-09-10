package com.example.todo.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Assignment implements Comparable<Assignment>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() { return isDeleted; }

    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    @Override
    public int compareTo(Assignment assignment) {
        if(this.getId() > assignment.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}