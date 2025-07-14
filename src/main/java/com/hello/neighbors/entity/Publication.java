package com.hello.neighbors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hello.neighbors.entity.enums.PublicationCategory;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String city;
    private String postalCode;
    private String street;
    private double latitude;
    private double longitude;
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> illustrations;

    private LocalDateTime publicationDate;
    private boolean isReported;
    private boolean isArchived;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> likes = new HashSet<>();

    @ManyToOne
    private Subscriber author;

    @JsonIgnore
    private List<CommentPublication> comments;

    @Enumerated(EnumType.STRING)
    PublicationCategory category;

    ///////////// Constructors ////////////////////

    public Publication() { }

    public Publication(
            String title, String city, String postalCode, String street, double latitude, double longitude,
            String description, List<String> illustrations, LocalDateTime publicationDate, boolean isReported,
            boolean isArchived, Subscriber author, PublicationCategory category
    ) {
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.illustrations = illustrations;
        this.publicationDate = publicationDate;
        this.isReported = isReported;
        this.isArchived = isArchived;
        this.author = author;
        this.category =  category;
    }

    public Publication(
            Long id, String title, String city, String postalCode, String street, double latitude, double longitude,
            String description, List<String> illustrations, LocalDateTime publicationDate, boolean isReported,
            boolean isArchived, Set<Long> likes, Subscriber author, PublicationCategory category
    ) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.illustrations = illustrations;
        this.publicationDate = publicationDate;
        this.isReported = isReported;
        this.isArchived = isArchived;
        this.likes = likes;
        this.author = author;
        this.category =  category;
    }

    ///////////// Getters and Setters ////////////////////

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getStreet() { return street; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getDescription() { return description; }
    public List<String> getIllustrations() { return illustrations; }
    public LocalDateTime getPublicationDate() { return publicationDate; }
    public boolean isReported() { return isReported; }
    public boolean isArchived() { return isArchived; }
    public Set<Long> getLikes() { return likes; }
    public Subscriber getAuthor() { return author; }
    public List<CommentPublication> getComments() { return comments; }
    public PublicationCategory getCategory() { return category; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCity(String city) { this.city = city; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setStreet(String street) { this.street = street; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setDescription(String description) { this.description = description; }
    public void setIllustrations(List<String> illustrations) { this.illustrations = illustrations; }
    public void setPublicationDate(LocalDateTime publicationDate) { this.publicationDate = publicationDate; }
    public void setReported(boolean reported) { isReported = reported; }
    public void setLikes(Set<Long> likes) { this.likes = likes; }
    public void setArchived(boolean archived) { isArchived = archived; }
    public void setAuthor(Subscriber author) { this.author = author; }
    public void setComments(List<CommentPublication> comments) { this.comments = comments; }
    public void setCategory(PublicationCategory category) {
        this.category = category;
    }
}
