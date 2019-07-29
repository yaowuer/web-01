package com.nf152.web01.bean;

public class Comment {
    private Integer id;
    private String content;

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
