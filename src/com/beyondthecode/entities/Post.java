package com.beyondthecode.entities;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private static Integer idIncrement = 0;

    private String contents;
    private String title;
    private User user;
    private Integer id;
//    private List<Comment> comments;

    public Post(String title, String contents){
        super();
        this.title = title;
        this.contents = contents;
        this.id = ++Post.idIncrement;
    }

    public Post(String title, String contents, User user) {
        super();
        this.title = title;
        this.contents = contents;
        this.user = user;
//        this.comments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.contents = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Titulo: " + title + " Conteudo: " + contents + " ID: " + id;
    }



//    public List<Comment> getComments() {
//        return comments;
//    }
//
//
//    public void addComment(Integer id, User user, String text){
//        comments.add(new Comment(id, user, text));
//    }


}
