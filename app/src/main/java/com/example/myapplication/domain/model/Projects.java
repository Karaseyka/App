package com.example.myapplication.domain.model;



public class Projects {

    private long id;
    private String name;
    private String description;
    private String user_nick;
    private String foto_id;


    public Projects(long id, String name, String description, String user_nick, String foto_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_nick = user_nick;
        this.foto_id = foto_id;
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
    public String getFoto_id() {
        return foto_id;
    }


}

