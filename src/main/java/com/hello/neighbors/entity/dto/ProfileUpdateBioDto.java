package com.hello.neighbors.entity.dto;

public class ProfileUpdateBioDto {

    private Long UserId;
    private String body;

    ///////////// Méthodes ////////////////////

    @Override
    public String toString() {
        return "ProfileUpdateBioDto{" +
                "UserId=" + UserId +
                ", body='" + body + '\'' +
                '}';
    }

    ///////////// Getters and Setters ////////////////////

    public Long getUserId() {
        return UserId;
    }
    public String getBody() {
        return body;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
