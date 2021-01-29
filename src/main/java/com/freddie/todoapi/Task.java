package com.freddie.todoapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String taskName;
    private String dueDate;
    private Boolean taskDone;
    private String username;

    protected Task() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Task(String taskName, Boolean taskDone, String dueDate, String username) {
        super();
        this.taskName = taskName;
        this.taskDone = taskDone;
        this.dueDate = dueDate;
        this.username = username;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettaskName() {
        return taskName;
    }

    public void settaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean gettaskDone() {
        return taskDone;
    }

    public void settaskDone(Boolean taskDone) {
        this.taskDone = taskDone;
    }

    public String toString() {
        return "Task [id=" + id + ", taskName=" + taskName + ", taskDone=" + taskDone + ", dueDate=" + dueDate
                + ", username=" + username + "]";
    }
}
