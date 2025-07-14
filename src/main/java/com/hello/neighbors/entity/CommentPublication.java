package com.hello.neighbors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class CommentPublication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private LocalDateTime creationDate;

    @ManyToOne
    private Subscriber author;
    @ManyToOne
    private Publication publication;
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentPublication parentComment;

    private boolean isModified;
    private boolean isReported;

    /////////////// Constructors //////////////

    public CommentPublication() { }

    public CommentPublication(
            String body, LocalDateTime creationDate,
            Subscriber author, Publication publication,
            CommentPublication parentComment, boolean isModified, boolean isReported) {
        this.body = body;
        this.creationDate = creationDate;
        this.author = author;
        this.publication = publication;
        this.parentComment = parentComment;
        this.isModified = isModified;
        this.isReported = isReported;
    }

    public CommentPublication(
            Long id, String body, LocalDateTime creationDate,
            Subscriber author, Publication publication,
            CommentPublication parentComment, boolean isModified, boolean isReported) {
        this.id = id;
        this.body = body;
        this.creationDate = creationDate;
        this.author = author;
        this.publication = publication;
        this.parentComment = parentComment;
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
    public Subscriber getAuthor() {
        return author;
    }
    public Publication getPublication() {
        return publication;
    }
    public CommentPublication getParentComment() {
        return parentComment;
    }
    public boolean getModified() {
        return isModified;
    }
    public boolean getReported() {
        return isReported;
    }

    /////////////// Setters //////////////////

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAuthor(Subscriber author) {
        this.author = author;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public void setParentComment(CommentPublication parentComment) {
        this.parentComment = parentComment;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }

    public void setReported(boolean reported) {
        isReported = reported;
    }
}
