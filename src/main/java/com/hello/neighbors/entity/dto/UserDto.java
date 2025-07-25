package com.hello.neighbors.entity.dto;

public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String pseudonym;
    private String email;
    private String token;
    private double latitude;
    private double longitude;
    private String city;
    private String postalCode;
    private String street;
    private boolean isInCity;

    ///////////// Constructors /////////////////

    public UserDto() {
    }

    public UserDto(Long id, String firstname, String lastname, String pseudonym, String email,
                   String token, double latitude, double longitude, String city,
                   String postalCode, String street, boolean isInCity) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudonym = pseudonym;
        this.email = email;
        this.token = token;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.isInCity = isInCity;
    }

    public UserDto(Long id, String firstname, String lastname, String pseudonym, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudonym = pseudonym;
        this.email = email;
    }

    ///////////// Getters & Setters /////////////////

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
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getPseudonym() {
        return pseudonym;
    }
    public String getEmail() {
        return email;
    }
    public String getCity() {
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getStreet() {
        return street;
    }
    public boolean isInCity() {
        return isInCity;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setInCity(boolean inCity) {
        isInCity = inCity;
    }
}
