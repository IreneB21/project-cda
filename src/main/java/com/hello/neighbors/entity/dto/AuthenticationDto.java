package com.hello.neighbors.entity.dto;

public class AuthenticationDto {

    private String email;
    private String password;

    ////////////// Getters ////////////////

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    ////////////// Setters ////////////////

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
