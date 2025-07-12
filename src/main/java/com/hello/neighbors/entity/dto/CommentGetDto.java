package com.hello.neighbors.entity.dto;

public class CommentGetDto {

    private String body;
    private Long authorId;
    private Long publicationId;
    private Long parentCommentId;

    ////////////// Constructors ////////////////

    public CommentGetDto() {
    }

    public CommentGetDto(String body, Long authorId, Long publicationId, Long parentCommentId) {
        this.body = body;
        this.authorId = authorId;
        this.publicationId = publicationId;
        this.parentCommentId = parentCommentId;
    }

    ///////////// Getters and Setters ////////////////////

    public String getBody() {
        return body;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public Long getPublicationId() {
        return publicationId;
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
    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }
    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
}
