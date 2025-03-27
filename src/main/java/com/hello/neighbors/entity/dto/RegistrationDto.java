package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.enums.RoleName;

public class RegistrationDto {

    private String lastname;
    private String firstname;
    private String pseudonym;
    private String password;
    private String email;
    private RoleName roleName;
    private String city;
    private String street;
    private String postalCode;
    private boolean isInCity;

    /////////////// Méthodes ////////////////

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", pseudonym='" + pseudonym + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleName=" + roleName +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", inCity=" + isInCity +
                '}';
    }

    /////////////// Getters ////////////////

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

    public RoleName getRoleName() {
        return roleName;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public boolean getIsInCity() {
        return isInCity;
    }

    /////////////// Setters ////////////////

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

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setIsInCity(boolean isInCity) {
        this.isInCity = isInCity;
    }
}
