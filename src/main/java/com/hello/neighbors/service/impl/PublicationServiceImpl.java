package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.PublicationCreateDto;
import com.hello.neighbors.entity.dto.PublicationDeleteDto;
import com.hello.neighbors.entity.dto.PublicationUpdateDto;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.service.PublicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    @Override
    public Publication create(PublicationCreateDto dto) {
        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());

        Publication publication = new Publication(
                dto.getTitle(),
                dto.getCity(),
                dto.getPostalCode(),
                dto.getStreet(),
                dto.getDescription(),
                dto.getIllustrations(),
                LocalDateTime.now(),
                false,
                false,
                0,
                author,
                dto.getCategory()
        );
        return publicationRepository.save(publication);
    }

    @Override
    @Transactional
    public Publication update(PublicationUpdateDto dto) {
        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());

        Publication publication = new Publication(
                dto.getPublicationId(),
                dto.getTitle(),
                dto.getCity(),
                dto.getPostalCode(),
                dto.getStreet(),
                dto.getDescription(),
                dto.getIllustrations(),
                LocalDateTime.now(),
                false,
                false,
                0,
                author,
                dto.getCategory()
        );
        return publicationRepository.save(publication);
    }

    @Override
    public void delete(PublicationDeleteDto dto) {

    }

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
}
