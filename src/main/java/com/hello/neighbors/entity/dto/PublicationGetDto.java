package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.enums.PublicationCategory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class PublicationGetDto implements PostDto {
    private Long id;
    private String title;
    private PublicationCategory category;
    private String city;
    private String postalCode;
    private String street;
    private double latitude;
    private double longitude;
    private String description;
    private List<String> illustrations;
    private AuthorDto author;
    private Set<Long> likes;
    private LocalDateTime publicationDate;

    ////////////// Constructors ////////////////

    public PublicationGetDto() {
    }

    public PublicationGetDto(Long id, String title, PublicationCategory category,
                             String city, String postalCode, String street, double latitude, double longitude,
                             String description, List<String> illustrations,
                             AuthorDto author, Set<Long> likes, LocalDateTime publicationDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.illustrations = illustrations;
        this.author = author;
        this.likes = likes;
        this.publicationDate = publicationDate;
    }

    ///////////// Getters and Setters ////////////////////

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public PublicationCategory getCategory() {
        return category;
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
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getIllustrations() {
        return illustrations;
    }
    public AuthorDto getAuthor() {
        return author;
    }
    public Set<Long> getLikes() {
        return likes;
    }
    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(PublicationCategory category) {
        this.category = category;
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
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIllustrations(List<String> illustrations) {
        this.illustrations = illustrations;
    }
    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
    public void setLikes(Set<Long> likes) {
        this.likes = likes;
    }
    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}
