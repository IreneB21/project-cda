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
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String city;
    private String postalCode;
    private String street;
    private String description;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> illustrations;

    private LocalDateTime publicationDate;
    private boolean isReported;
    private boolean isArchived;
    private int likes;

    @ManyToOne
    private Subscriber author;
    @JsonIgnore
    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    PublicationCategory category;

    ///////////// Constructors ////////////////////

    public Publication() { }

    public Publication(String title, String city, String postalCode, String street, String description,
                       List<String> illustrations, LocalDateTime publicationDate, boolean isReported,
                       boolean isArchived, int likes, Subscriber author, PublicationCategory category) {
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.description = description;
        this.illustrations = illustrations;
        this.publicationDate = publicationDate;
        this.isReported = isReported;
        this.isArchived = isArchived;
        this.likes = likes;
        this.author = author;
        this.category =  category;
    }

    public Publication(Long id, String title, String city, String postalCode, String street, String description,
                       List<String> illustrations, LocalDateTime publicationDate, boolean isReported,
                       boolean isArchived, int likes, Subscriber author, PublicationCategory category) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
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
    public String getDescription() { return description; }
    public List<String> getIllustrations() { return illustrations; }
    public LocalDateTime getPublicationDate() { return publicationDate; }
    public boolean isReported() { return isReported; }
    public boolean isArchived() { return isArchived; }
    public int getLikes() { return likes; }
    public Subscriber getAuthor() { return author; }
    public List<Comment> getComments() { return comments; }
    public PublicationCategory getCategory() { return category; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCity(String city) { this.city = city; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public void setStreet(String street) { this.street = street; }
    public void setDescription(String description) { this.description = description; }
    public void setIllustrations(List<String> illustrations) { this.illustrations = illustrations; }
    public void setPublicationDate(LocalDateTime publicationDate) { this.publicationDate = publicationDate; }
    public void setReported(boolean reported) { isReported = reported; }
    public void setArchived(boolean archived) { isArchived = archived; }
    public void setLikes(int likes) { this.likes = likes; }
    public void setAuthor(Subscriber author) { this.author = author; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
    public void setCategory(PublicationCategory category) {
        this.category = category;
    }
}
