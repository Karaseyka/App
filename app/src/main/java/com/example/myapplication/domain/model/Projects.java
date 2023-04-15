package com.example.myapplication.domain.model;



public class Projects {

    private long id;
    private String name;
    private String description;
    private String user_nick;


    public Projects(long id, String name, String description, String user_nick) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_nick = user_nick;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUser_nick(){return user_nick;}


}

