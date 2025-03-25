package com.hello.neighbors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private LocalDateTime creationDate;
    private Long authorId;
    private Long publicationOrCommentId;
    private boolean isModified;
    private boolean isReported;

    /////////////// Constructors //////////////

    public Comment() { }

    public Comment(
            Long id, String body, LocalDateTime creationDate,
            Long authorId, Long publicationOrCommentId,
            boolean isModified, boolean isReported)
    {
        this.id = id;
        this.body = body;
        this.creationDate = creationDate;
        this.authorId = authorId;
        this.publicationOrCommentId = publicationOrCommentId;
        this.isModified = isModified;
        this.isReported = isReported;
    }

    /////////////// Getters //////////////////

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getPublicationOrCommentId() {
        return publicationOrCommentId;
    }

    public boolean isModified() {
        return isModified;
    }

    public boolean isReported() {
        return isReported;
    }
}
