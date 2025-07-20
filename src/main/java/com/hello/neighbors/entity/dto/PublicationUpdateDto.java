package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.enums.PublicationCategory;

import java.util.List;

public class PublicationUpdateDto {

    private Long publicationId;
    private String title;
    private String city;
    private String postalCode;
    private String street;
    private String description;
    private List<String> illustrations;

    ///////////// Méthodes ////////////////////

    @Override
    public String toString() {
        return "PublicationUpdateDto{" +
                "publicationId=" + publicationId +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", description='" + description + '\'' +
                ", illustrations=" + illustrations +
                '}';
    }

    ///////////// Getters and Setters ////////////////////

    public Long getPublicationId() {
        return publicationId;
    }
    public String getTitle() {
        return title;
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
    public String getDescription() {
        return description;
    }
    public List<String> getIllustrations() {
        return illustrations;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIllustrations(List<String> illustrations) {
        this.illustrations = illustrations;
    }
}
