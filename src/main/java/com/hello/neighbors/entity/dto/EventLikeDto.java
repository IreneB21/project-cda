package com.hello.neighbors.entity.dto;

public class EventLikeDto {
    private Long userId;

    public EventLikeDto(Long userId) {
        this.userId = userId;
    }

    ////////////// Getters & Setters ////////////////

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
