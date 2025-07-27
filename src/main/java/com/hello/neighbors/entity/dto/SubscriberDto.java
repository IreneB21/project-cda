package com.hello.neighbors.entity.dto;

import java.time.LocalDate;

public class SubscriberDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String pseudonym;
    private String email;
    private double latitude;
    private double longitude;
    private String city;
    private String postalCode;
    private String street;
    private boolean isInCity;
    private LocalDate birthdate;
    private String phone;
    private String picture;
    private LocalDate registrationDate;

    ///////////// Constructors ////////////////////

    public SubscriberDto() {
    }

    public SubscriberDto(Long id, String firstname, String lastname, String pseudonym, String email,
                         double latitude, double longitude, String city, String postalCode, String street,
                         boolean isInCity, LocalDate birthdate, String phone, String picture, LocalDate registrationDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudonym = pseudonym;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.isInCity = isInCity;
        this.birthdate = birthdate;
        this.phone = phone;
        this.picture = picture;
        this.registrationDate = registrationDate;
    }

    ///////////// Getters & Setters////////////////////

    public Long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPseudonym() {
        return pseudonym;
    }
    public String getEmail() {
        return email;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
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
    public boolean getIsInCity() {
        return isInCity;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public String getPhone() {
        return phone;
    }
    public String getPicture() {
        return picture;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
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
    public void setIsInCity(boolean inCity) {
        isInCity = inCity;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
