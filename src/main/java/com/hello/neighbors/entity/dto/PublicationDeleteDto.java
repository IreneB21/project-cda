package com.hello.neighbors.entity.dto;

public class PublicationDeleteDto {

    private Long publicationId;
    private Long authorId;

    ///////////// Getters and Setters ////////////////////

    public Long getPublicationId() {
        return publicationId;
    }
    public Long getAuthorId() {
        return authorId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
