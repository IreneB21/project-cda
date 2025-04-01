package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.enums.NotificationType;

import java.time.LocalDateTime;

public class NotificationCreateDto {

    private NotificationType type;
    private String content;
    private LocalDateTime date;
    private boolean isRead;
    private boolean isArchived;
    private Long recipientId;

    ///////////// Getters and Setters ////////////////////

    public NotificationType getType() {
        return type;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public boolean isRead() {
        return isRead;
    }
    public boolean isArchived() {
        return isArchived;
    }
    public Long getRecipientId() {
        return recipientId;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setRead(boolean read) {
        isRead = read;
    }
    public void setArchived(boolean archived) {
        isArchived = archived;
    }
    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
