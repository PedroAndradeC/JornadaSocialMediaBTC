package com.beyondthecode.entity;

import java.util.ArrayList;
import java.util.List;


public class User extends Comment{

    private Integer id;
    private String email;
    private String password;
    private String name;

    public User () {
        super();
        this.name = name;
    }

    public User (String email, String password, String name) {
        super();
        this.email = email;
        this.password = password;
        this.name = name;
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

    public Integer getId() {
        return id;
    }
    public Integer setId(int id) {
        return this.id = id;
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
        return "id:" + id + " nome: " + name + " email: " + email + " senha: " + password;
    }

}
