package com.hello.neighbors.entity.dto;

public class CommentGetDto {

    private Long id;
    private String body;
    private Long authorId;
    private Long parentId;
    private Long parentCommentId;

    ////////////// Constructors ////////////////

    public CommentGetDto() {
    }

    public CommentGetDto(Long id, String body, Long authorId, Long parentId, Long parentCommentId) {
        this.id = id;
        this.body = body;
        this.authorId = authorId;
        this.parentId = parentId;
        this.parentCommentId = parentCommentId;
    }



    ///////////// Getters and Setters ////////////////////

    public Long getId() {
        return id;
    }
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

    public void setId(Long id) {
        this.id = id;
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
