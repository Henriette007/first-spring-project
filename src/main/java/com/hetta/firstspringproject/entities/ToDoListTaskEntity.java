package com.hetta.firstspringproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "ToDoListTasks")
public class ToDoListTaskEntity extends IdentifiedEntity{
    @Column
    private String task;

    @Column
    private boolean done;

    public ToDoListTaskEntity(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public ToDoListTaskEntity() {
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
