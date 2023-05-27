package com.beyondthecode.entities;

public class Comment {

    private Integer id;
    private User user;
    private String text;

    public Comment(Integer id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public Comment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
