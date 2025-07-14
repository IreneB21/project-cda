package com.hello.neighbors.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class CommentEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private LocalDateTime creationDate;

    @ManyToOne
    private Subscriber author;
    @ManyToOne
    private Event event;
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentEvent parentComment;

    private boolean isModified;
    private boolean isReported;

    /////////////// Constructors //////////////

    public CommentEvent() { }

    public CommentEvent(
            String body, LocalDateTime creationDate,
            Subscriber author, Event event,
            CommentEvent parentComment, boolean isModified, boolean isReported) {
        this.body = body;
        this.creationDate = creationDate;
        this.author = author;
        this.event = event;
        this.parentComment = parentComment;
        this.isModified = isModified;
        this.isReported = isReported;
    }

    public CommentEvent(
            Long id, String body, LocalDateTime creationDate,
            Subscriber author, Event event,
            CommentEvent parentComment, boolean isModified, boolean isReported) {
        this.id = id;
        this.body = body;
        this.creationDate = creationDate;
        this.author = author;
        this.event = event;
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
    public Event getEvent() {
        return event;
    }
    public CommentEvent getParentComment() {
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
    public void setEvent(Event event) {
        this.event = event;
    }
    public void setParentComment(CommentEvent parentComment) {
        this.parentComment = parentComment;
    }
    public void setModified(boolean modified) {
        isModified = modified;
    }
    public void setReported(boolean reported) {
        isReported = reported;
    }
}
