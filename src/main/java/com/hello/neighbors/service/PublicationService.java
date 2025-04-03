package com.hello.neighbors.service;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.PublicationCreateDto;
import com.hello.neighbors.entity.dto.PublicationDeleteDto;
import com.hello.neighbors.entity.dto.PublicationUpdateDto;
import com.hello.neighbors.entity.dto.PublicationUpdateLikesDto;
import org.springframework.http.ResponseEntity;

public interface PublicationService {

    Publication create(PublicationCreateDto dto);
    Publication update(PublicationUpdateDto dto);
    Publication manageLikes(PublicationUpdateLikesDto dto);
    void delete(PublicationDeleteDto dto);
}
