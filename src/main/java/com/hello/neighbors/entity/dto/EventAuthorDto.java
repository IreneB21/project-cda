package com.hello.neighbors.entity.dto;

public class EventAuthorDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String pseudonym;
    private String picture;

    ////////////// Constructors ////////////////

    public EventAuthorDto() {}

    public EventAuthorDto(Long id, String firstname, String lastname, String pseudonym, String picture) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudonym = pseudonym;
        this.picture = picture;
    }

    ////////////// Getters & Setters ////////////////

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPseudonym() { return pseudonym; }
    public void setPseudonym(String pseudonym) { this.pseudonym = pseudonym; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }
}
