package com.beyondthecode.entity;


public class User extends Comment{ // excluir essa extensão

    private Integer id;
    private String email;
    private String password;
    private String name;

    public User () {
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
    public void setId(int id) {
        this.id = id;
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

