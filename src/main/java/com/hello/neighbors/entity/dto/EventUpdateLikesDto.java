package com.hello.neighbors.entity.dto;

public class EventUpdateLikesDto {

    private Long eventId;
    private Long userId;
    private boolean addLike;

    ///////////// Getters and Setters ////////////////////

    public Long getEventId() {
        return eventId;
    }
    public Long getUserId() {
        return userId;
    }
    public boolean isAddLike() {
        return addLike;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setAddLike(boolean addLike) {
        this.addLike = addLike;
    }
}
