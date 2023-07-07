package com.beyondthecode.entity;

public class Post {
    private String contents;
    private String title;
    private Integer idPost;
    private User user;

    public Post( ) {
    }

    public Post (String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    @Override
    public String toString() {
        return "\n"+"Titulo:  " + title + "\nConteudo: " + contents + "\nID do Post: " + idPost +"\n-----------------------------------------------";
    }

}

