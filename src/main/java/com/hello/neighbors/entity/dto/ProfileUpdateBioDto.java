package com.hello.neighbors.entity.dto;

public class ProfileUpdateBioDto {

    private Long userId;
    private String body;

    ///////////// Méthodes ////////////////////

    @Override
    public String toString() {
        return "ProfileUpdateBioDto{" +
                "UserId=" + userId +
                ", body='" + body + '\'' +
                '}';
    }

    ///////////// Getters and Setters ////////////////////

    public Long getUserId() {
        return userId;
    }
    public String getBody() {
        return body;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
