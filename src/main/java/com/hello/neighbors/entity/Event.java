package com.hello.neighbors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> likes = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> illustrations;

    @ManyToOne
    private Subscriber author;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<CommentEvent> comments;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Subscriber> participants = new ArrayList<>();;

    ///////////// Constructors ////////////////////

    public Event() {
    }

    public Event(
            Long id, String title, String city, String postalCode, String street,
            double latitude, double longitude,
            LocalDateTime startDate, LocalDateTime endDate, String description,
            Set<Long> likes, List<String> illustrations, Subscriber author,
            List<Subscriber> participants)
    {
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
        this.likes = likes;
        this.illustrations = illustrations;
        this.author = author;
        this.participants = participants;
    }

    public Event(
            String title, String city, String postalCode, String street,
            float latitude, float longitude,
             LocalDateTime startDate, LocalDateTime endDate,
             String description, LocalDateTime creationDate,
            List<String> illustrations, Subscriber author
    ) {
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.creationDate = creationDate;
        this.illustrations = illustrations;
        this.author = author;
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
    public String getStreet() {
        return street;
    }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public Set<Long> getLikes() { return likes; }
    public List<String> getIllustrations() {
        return illustrations;
    }
    public Subscriber getAuthor() {
        return author;
    }
    public List<CommentEvent> getComments() {
        return comments;
    }
    public List<Subscriber> getParticipants() {
        return participants;
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
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public void setLikes(Set<Long> likes) { this.likes = likes; }
    public void setIllustrations(List<String> illustrations) {
        this.illustrations = illustrations;
    }
    public void setAuthor(Subscriber author) {
        this.author = author;
    }
    public void setComments(List<CommentEvent> comments) {
        this.comments = comments;
    }
    public void setParticipants(List<Subscriber> participants) {
        this.participants = participants;
    }
}
