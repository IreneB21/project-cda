package com.hello.neighbors.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EventCreateDto {

    private String title;
    private String city;
    private String postalCode;
    private String street;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private List<String> illustrations;
    private Long authorId;

    ///////////// Getters and Setters ////////////////////

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
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public String getDescription() {
        return description;
    }
    public List<String> getIllustrations() {
        return illustrations;
    }
    public Long getAuthorId() {
        return authorId;
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
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIllustrations(List<String> illustrations) {
        this.illustrations = illustrations;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
