package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.PublicationCreateDto;
import com.hello.neighbors.entity.dto.PublicationDeleteDto;
import com.hello.neighbors.entity.dto.PublicationUpdateDto;
import com.hello.neighbors.entity.enums.PublicationCategory;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.service.PublicationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationServiceImpl implements PublicationService {

    private static final Logger logger = LogManager.getLogger();

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

        Publication publication = publicationRepository.findById(dto.getPublicationId())
                .orElseThrow(() -> new EntityNotFoundException("Publication non trouvée"));

        publication.setTitle(dto.getTitle());
        publication.setCity(dto.getCity());
        publication.setPostalCode(dto.getPostalCode());
        publication.setStreet(dto.getStreet());
        publication.setDescription(dto.getDescription());
        publication.setIllustrations(dto.getIllustrations());

        return publicationRepository.save(publication);
    }


    @Override
    public void delete(PublicationDeleteDto dto) {
        logger.info("Publication ID passé: " + dto.getPublicationId());

        Optional<Publication> publicationToDelete = publicationRepository.findById(dto.getPublicationId());
        if (publicationToDelete.isEmpty()) {
            logger.info("Publication non trouvée pour l'ID: " + dto.getPublicationId());
        }
        publicationRepository.deleteById(dto.getPublicationId());
    }

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
}
