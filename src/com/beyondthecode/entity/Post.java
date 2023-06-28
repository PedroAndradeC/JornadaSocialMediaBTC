package com.beyondthecode.entity;

public class Post {
    private String contents;
    private String title;
    private Integer id;

    public Post( ) {
        super();
        this.title = title;
    }

    public Post (String title, String contents) {
        super();
        this.title = title;
        this.contents = contents;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Titulo: " + title + " Conteudo: " + contents + " ID: " + id;
    }

}
