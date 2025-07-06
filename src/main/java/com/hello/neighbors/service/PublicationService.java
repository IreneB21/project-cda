package com.hello.neighbors.service;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicationService {

    Publication create(PublicationCreateDto dto);
    Publication update(PublicationUpdateDto dto);
    Publication manageLikes(PublicationUpdateLikesDto dto);
    void delete(PublicationDeleteDto dto);
    List<PublicationGetDto> getUserPublications(long id);
    List<PublicationGetDto> fetchAll();
}
