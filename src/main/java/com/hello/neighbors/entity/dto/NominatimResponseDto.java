package com.hello.neighbors.entity.dto;

public class NominatimResponseDto {

    private String lat;
    private String lon;

    /////////////// Getters and Setters ////////////////

    public String getLat() {
        return lat;
    }
    public String getLon() {
        return lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
}
