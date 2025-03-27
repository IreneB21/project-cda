package com.hello.neighbors.entity.dto;

public class UserDto {

    private final Long id;
    private final String firstname;
    private final String lastname;
    private final String token;

    ///////////// Constructors /////////////////

    public UserDto(Long id, String firstname, String lastname, String token) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.token = token;
    }

    ///////////// Getters /////////////////

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getToken() {
        return token;
    }
}
