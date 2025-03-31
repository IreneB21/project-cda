package com.hello.neighbors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String city;
    private String postalCode;
    private String street;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private int likes;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> illustrations;

    @ManyToOne
    private Subscriber author;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Subscriber> participants;

    ///////////// Constructors ////////////////////

    public Event() {
    }

    public Event(Long id, String title, String city, String postalCode, String street,
                 LocalDateTime startDate, LocalDateTime endDate,
                 String description, int likes, List<String> illustrations,
                 Subscriber author, List<Subscriber> participants) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.likes = likes;
        this.illustrations = illustrations;
        this.author = author;
        this.participants = participants;
    }

    public Event(String title, String city, String postalCode, String street,
                 LocalDateTime startDate, LocalDateTime endDate,
                 String description, List<String> illustrations,
                 Subscriber author) {
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
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
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public String getDescription() {
        return description;
    }
    public int getLikes() {
        return likes;
    }
    public List<String> getIllustrations() {
        return illustrations;
    }
    public Subscriber getAuthor() {
        return author;
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
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setIllustrations(List<String> illustrations) {
        this.illustrations = illustrations;
    }
    public void setAuthor(Subscriber author) {
        this.author = author;
    }
    public void setParticipants(List<Subscriber> participants) {
        this.participants = participants;
    }
}
