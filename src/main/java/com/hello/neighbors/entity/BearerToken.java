package com.hello.neighbors.entity;

public class BearerToken {

    private final String accessToken ;
    private final String tokenType ;

    //////////////// Constructors //////////////////////

    public BearerToken(String accessToken , String tokenType) {
        this.tokenType = tokenType ;
        this.accessToken = accessToken;
    }

    //////////////// Getters //////////////////////

    public String getAccessToken() {
        return accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
}
