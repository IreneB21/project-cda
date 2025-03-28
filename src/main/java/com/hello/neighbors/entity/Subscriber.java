package com.hello.neighbors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hello.neighbors.entity.enums.WithdrawalReason;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Subscriber extends User {

    private String city;
    private String postalCode;
    private String street;
    private boolean isInCity;
    private LocalDate birthdate;
    private String introduction;
    private String phone;
    private String picture;
    private int notificationPreferences;
    private List<Long> contacts;
    private LocalDate registrationDate;
    private LocalDate withdrawalDate;
    @Enumerated(EnumType.STRING)
    private WithdrawalReason withdrawalReason;
    private LocalDate lastActivityDate;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Publication> publications;

    ///////////// Constructors ////////////////////

    public Subscriber() { }

    public Subscriber(
            String lastname, String firstname, String pseudonym, String password,
            String email, List<Role> roles, String city,
            String postalCode, String street, boolean isInCity, LocalDate birthdate, String introduction,
            String picture, String phone, int notificationPreferences, List<Long> contacts,
            LocalDate registrationDate, LocalDate withdrawalDate, WithdrawalReason withdrawalReason,
            LocalDate lastActivityDate)
    {
        super(null, lastname, firstname, pseudonym, password, email, roles);
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.isInCity = isInCity;
        this.birthdate = birthdate;
        this.introduction = introduction;
        this.picture = picture;
        this.phone = phone;
        this.notificationPreferences = notificationPreferences;
        this.contacts = contacts;
        this.registrationDate = registrationDate;
        this.withdrawalDate = withdrawalDate;
        this.withdrawalReason = withdrawalReason;
        this.lastActivityDate = null;
    }

    ///////////// Getters ////////////////////

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
    public List<Long> getContacts() {
        return contacts;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public LocalDate getWithdrawalDate() {
        return withdrawalDate;
    }
    public WithdrawalReason getWithdrawalReason() {
        return withdrawalReason;
    }
    public LocalDate getLastActivityDate() {
        return lastActivityDate;
    }
    public List<Comment> getComments() { return comments; }
    public List<Publication> getPublications() { return publications; }

    ///////////// Setters ////////////////////

    public void setCity(String city) {
        this.city = city;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setIsInCity(boolean isInCity) {
        this.isInCity = isInCity;
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
    public void setContacts(List<Long> contacts) {
        this.contacts = contacts;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    public void setWithdrawalDate(LocalDate withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }
    public void setWithdrawalReason(WithdrawalReason withdrawalReason) {
        this.withdrawalReason = withdrawalReason;
    }
    public void setLastActivityDate(LocalDate lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }
    public void setComments(List<Comment> comments) { this.comments = comments; }
    public void setPublications(List<Publication> publications) { this.publications = publications; }
}
