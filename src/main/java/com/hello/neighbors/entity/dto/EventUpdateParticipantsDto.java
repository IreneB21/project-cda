package com.hello.neighbors.entity.dto;

public class EventUpdateParticipantsDto {

    private Long eventId;
    private Long userId;
    private boolean join;

    ///////////// Getters and Setters ////////////////////

    public Long getEventId() {
        return eventId;
    }
    public Long getUserId() {
        return userId;
    }
    public boolean isJoin() {
        return join;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setJoin(boolean join) {
        this.join = join;
    }
}
