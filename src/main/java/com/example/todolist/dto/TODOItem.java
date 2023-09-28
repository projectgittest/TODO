package com.example.todolist.dto;

public class TODOItem {

    private Long id;

    private String username;

    private String title;

    private Boolean done;

   public TODOItem (){

   }

    public TODOItem(Long id, String username, String title, boolean done) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
