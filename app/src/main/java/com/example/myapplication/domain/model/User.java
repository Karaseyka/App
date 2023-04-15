package com.example.myapplication.domain.model;

public class User {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String photoURL;

    public User(long id, String name, String email, String phone, String photoURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.photoURL = photoURL;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone(){return phone;}

    public String getPhotoURL() {
        return photoURL;
    }
}
