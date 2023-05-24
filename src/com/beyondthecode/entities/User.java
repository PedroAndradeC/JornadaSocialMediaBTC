package com.beyondthecode.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String password;
    private String name;

    private List<Post> posts;

    public User () {
        super();
    }
    public User (String email, String password, String name) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.posts = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "nome: " + name + " email: " + email + " senha: " + password;
    }
}
