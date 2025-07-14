package com.hello.neighbors.entity.dto;

import java.time.LocalDateTime;

public class CommentCreateDto {

    private String body;
    private Long authorId;
    private Long parentId;
    private Long parentCommentId;

    ///////////// Getters and Setters ////////////////////

    public String getBody() {
        return body;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public Long getParentId() {
        return parentId;
    }
    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}
