package com.example.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Assignment implements Comparable<Assignment>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private boolean isDeleted;

    @Override
    public int compareTo(Assignment assignment) {
        if(this.getId() > assignment.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}