package com.hello.neighbors.entity.dto;

public class EventUpdateParticipantsDto {

    private Long id;
    private Long newParticipantId;

    ///////////// Getters and Setters ////////////////////

    public Long getId() {
        return id;
    }
    public Long getNewParticipantId() {
        return newParticipantId;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNewParticipantId(Long newParticipantId) {
        this.newParticipantId = newParticipantId;
    }
}
