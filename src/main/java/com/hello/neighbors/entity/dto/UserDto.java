package com.hello.neighbors.entity.dto;

public class UserDto {

    private final Long id;
    private final String firstname;
    private final String lastname;
    private final String token;
    private final String latitude;
    private  final String longitude;

    ///////////// Constructors /////////////////

    public UserDto(Long id, String firstname, String lastname, String token, String latitude, String longitude) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.token = token;
        this.latitude = latitude;
        this.longitude = longitude;
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
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
}
