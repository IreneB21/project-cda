package com.hello.neighbors.entity;

import com.hello.neighbors.entity.enums.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private NotificationType type;
    private String content;
    private LocalDateTime date;
    private boolean isRead;
    private boolean isArchived;

    @ManyToOne
    private Subscriber recipientUser;

    ///////////// Constructors ////////////////////

    public Notification() {
    }

    public Notification(
            Long id, NotificationType type, String content,
            LocalDateTime date, boolean isRead, boolean isArchived,
            Subscriber recipientUser
    ) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.date = date;
        this.isRead = isRead;
        this.isArchived = isArchived;
        this.recipientUser = recipientUser;
    }

    public Notification(
            NotificationType type, String content,
            LocalDateTime date, boolean isRead, boolean isArchived,
            Subscriber recipientUser
    ) {
        this.type = type;
        this.content = content;
        this.date = date;
        this.isRead = isRead;
        this.isArchived = isArchived;
        this.recipientUser = recipientUser;
    }

    ///////////// Getters and Setters ////////////////////

    public Long getId() { return id; }
    public NotificationType getType() { return type; }
    public String getContent() { return content; }
    public LocalDateTime getDate() { return date; }
    public boolean isRead() { return isRead; }
    public boolean isArchived() { return isArchived; }
    public Subscriber getRecipientUser() { return recipientUser; }

    public void setId(Long id) { this.id = id; }
    public void setType(NotificationType type) { this.type = type; }
    public void setContent(String content) { this.content = content; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public void setRead(boolean read) { isRead = read; }
    public void setArchived(boolean archived) { isArchived = archived; }
    public void setRecipientUser(Subscriber recipientUser) { this.recipientUser = recipientUser; }
}
