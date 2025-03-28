package com.hello.neighbors.entity.dto;

public class CommentUpdateDto {

    private Long id;
    private String body;

    ///////////// Méthodes ////////////////////

    @Override
    public String toString() {
        return "CommentUpdateDto{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }

    ///////////// Getters and Setters ////////////////////


    public Long getId() {
        return id;
    }
    public String getBody() {
        return body;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
