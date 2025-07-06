package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.Event;

import java.time.LocalDateTime;

public record EventDto(
        Long id,
        String title,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
    public static EventDto from(Event e) {
        return new EventDto(e.getId(), e.getTitle(), e.getDescription(), e.getStartDate(), e.getEndDate());
    }
}

