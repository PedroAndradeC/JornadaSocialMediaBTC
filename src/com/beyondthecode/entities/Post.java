package com.beyondthecode.entities;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private String contents;
    private User user;
    private List<Comment> comments;
    private int likes;

    public Post (){
        super();
    }

    public Post(String contents, User user) {
        super();
        this.contents = contents;
        this.user = user;
        this.comments = new ArrayList<>();
        this.likes = 0;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }

    public void addComment(Integer id, User user, String text){
        comments.add(new Comment(id, user, text));
    }

    public void like(){
        likes++;
    }
}
