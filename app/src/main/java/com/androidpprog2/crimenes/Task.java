package com.androidpprog2.crimenes;

import java.io.Serializable;
import java.util.UUID;

public class Task implements Serializable {

    private Integer userId;
    private String id;
    private String title;
    private boolean completed;

    public Task(String title, boolean completed){
        id = UUID.randomUUID().toString();
        this.title = title;
        this.completed = completed;
    }


    public String getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
