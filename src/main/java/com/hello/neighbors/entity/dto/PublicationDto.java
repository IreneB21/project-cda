package com.hello.neighbors.entity.dto;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.enums.PublicationCategory;

public record PublicationDto(
    Long id,
    String title,
    String description,
    PublicationCategory category
) {
    public static PublicationDto from(Publication p) {
        return new PublicationDto(p.getId(), p.getTitle(), p.getDescription(), p.getCategory());
    }
}