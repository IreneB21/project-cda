package com.hello.neighbors.entity;

import com.hello.neighbors.entity.enums.EventType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

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
    private EventType eventType;
    
}
