package com.hello.neighbors.entity.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class EventGetDto implements PostDto {
    private Long id;
    private String title;
    private String city;
    private String postalCode;
    private String street;
    private double latitude;
    private double longitude;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private List<String> illustrations;
    private List<EventParticipantDto> participants;
    private EventAuthorDto author;
    private Set<EventLikeDto> likes;
    private LocalDateTime creationDate;

    ////////////// Constructors ////////////////

    public EventGetDto() {}

    public EventGetDto(Long id, String title, String city, String postalCode, String street, double latitude,
                       double longitude, LocalDateTime startDate, LocalDateTime endDate, String description,
                       List<String> illustrations, List<EventParticipantDto> participants,
                       EventAuthorDto author, Set<EventLikeDto> likes, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.illustrations = illustrations;
        this.participants = participants;
        this.author = author;
        this.likes = likes;
        this.creationDate = creationDate;
    }

    ///////////// Getters and Setters ////////////////////

    public Long getId() {
        return id;
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
    public String getStreet() { return street; }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
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
    public List<EventParticipantDto> getParticipants() {
        return participants;
    }
    public EventAuthorDto getAuthor() { return author; }
    public Set<EventLikeDto> getLikes() {
        return likes;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
    public void setParticipants(List<EventParticipantDto> participants) {
        this.participants = participants;
    }
    public void setAuthor(EventAuthorDto author) { this.author = author; }
    public void setLikes(Set<EventLikeDto> likes) {
        this.likes = likes;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
