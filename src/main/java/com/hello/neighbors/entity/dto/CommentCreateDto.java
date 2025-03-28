package com.hello.neighbors.entity.dto;

import java.time.LocalDateTime;

public class CommentCreateDto {

    private String body;
    private Long authorId;
    private Long publicationId;
    private Long parentCommentId;

    ///////////// Méthodes ////////////////////

    @Override
    public String toString() {
        return "CommentCreateDto{" +
                "body='" + body + '\'' +
                ", authorId=" + authorId +
                ", publicationId=" + publicationId +
                ", parentCommentId=" + parentCommentId +
                '}';
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
