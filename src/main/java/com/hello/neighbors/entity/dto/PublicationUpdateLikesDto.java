package com.hello.neighbors.entity.dto;

public class PublicationUpdateLikesDto {

    private Long publicationId;
    private Long userId;
    private boolean addLike;

    ///////////// Getters and Setters ////////////////////

    public Long getPublicationId() {
        return publicationId;
    }
    public Long getUserId() {
        return userId;
    }
    public boolean isAddLike() {
        return addLike;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setAddLike(boolean addLike) {
        this.addLike = addLike;
    }
}
