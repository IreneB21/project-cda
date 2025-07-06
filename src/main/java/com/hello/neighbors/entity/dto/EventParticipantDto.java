package com.hello.neighbors.entity.dto;

public class EventParticipantDto {
    private Long id;
    private String firstname;
    private String lastname;

    public EventParticipantDto(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    ////////////// Getters & Setters ////////////////

    public Long getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }

    public void setId(Long id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}
