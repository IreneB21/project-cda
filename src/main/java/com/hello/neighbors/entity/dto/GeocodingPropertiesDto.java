package com.hello.neighbors.entity.dto;

public class GeocodingPropertiesDto {
    private String label;
    private String name;
    private String city;
    private String postcode;

    public GeocodingPropertiesDto(String label, String name, String city, String postcode) {
        this.label = label;
        this.name = name;
        this.city = city;
        this.postcode = postcode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
