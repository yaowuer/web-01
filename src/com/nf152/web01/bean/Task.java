package com.nf152.web01.bean;

public class Task {
    private Integer id;
    private String content;
    private String status;

    public Task() {
    }

    public Task(String content, String status) {
        this.content = content;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
