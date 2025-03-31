package com.hello.neighbors.entity.dto;

import java.time.LocalDate;

public class ProfileUpdateDto {

    private Long UserId;
    private String lastname;
    private String firstname;
    private String pseudonym;
    private String password;
    private String email;
    private String city;
    private String postalCode;
    private String street;
    private boolean isInCity;
    private LocalDate birthdate;
    private String introduction;
    private String phone;
    private String picture;
    private int notificationPreferences;

    ///////////////// Getters and Setters ////////////////////

    public Long getUserId() {
        return UserId;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getPseudonym() {
        return pseudonym;
    }
    public String getPassword() {
        return password;
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
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public String getIntroduction() {
        return introduction;
    }
    public String getPhone() {
        return phone;
    }
    public String getPicture() {
        return picture;
    }
    public int getNotificationPreferences() {
        return notificationPreferences;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setNotificationPreferences(int notificationPreferences) {
        this.notificationPreferences = notificationPreferences;
    }
}
