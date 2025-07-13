package com.hello.neighbors.entity.dto;

public class GeocodingResponseDto {
    private String place_id;
    private String lat;
    private String lon;
    private String display_name;

    public GeocodingResponseDto() {}

    public GeocodingResponseDto(String place_id, String lat, String lon, String display_name) {
        this.display_name = display_name;
        this.lat = lat;
        this.lon = lon;
        this.place_id = place_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public double getParsedLat() {
        return Double.parseDouble(lat);
    }

    public double getParsedLon() {
        return Double.parseDouble(lon);
    }
}
