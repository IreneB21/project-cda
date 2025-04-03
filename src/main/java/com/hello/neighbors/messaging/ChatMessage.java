package com.hello.neighbors.messaging;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
/*
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime timestamp;


    /////////////// Constructors //////////////////

    public ChatMessage() {
        this.timestamp = LocalDateTime.now();
    }

    /////////////// Getters and Setters //////////////////

    public Long getId() {
        return id;
    }
    public String getSenderId() {
        return senderId;
    }
    public String getReceiverId() {
        return receiverId;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
*/