package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.service.GeocodingService;
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
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    private static final Logger logger = LogManager.getLogger();

    private PublicationRepository publicationRepository;
    private GeocodingService geocodingService;

    @Override
    public Publication create(PublicationCreateDto dto) {
        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());
        Publication publication = new Publication();

        publication.setTitle(dto.getTitle());
        publication.setCity(dto.getCity());
        publication.setPostalCode(dto.getPostalCode());
        publication.setStreet(dto.getStreet());

        Optional<double[]> coordinates = geocodingService.geocodeAddress(
                dto.getStreet(),
                dto.getPostalCode(),
                dto.getCity()
        );
        coordinates.ifPresent(coords -> {
            publication.setLatitude(coords[0]);
            publication.setLongitude(coords[1]);
        });

        publication.setDescription(dto.getDescription());
        publication.setIllustrations(dto.getIllustrations());
        publication.setPublicationDate(LocalDateTime.now());
        publication.setArchived(false);
        publication.setReported(false);
        publication.setAuthor(author);
        publication.setCategory(dto.getCategory());

        //author.setPublications(publication);
        return publicationRepository.save(publication);
    }

    @Override
    @Transactional
    public Publication update(PublicationUpdateDto dto) {
        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());

        Publication publication = publicationRepository.findById(dto.getPublicationId())
                .orElseThrow(() -> new EntityNotFoundException("PPublication not found"));

        publication.setTitle(dto.getTitle());
        publication.setCity(dto.getCity());
        publication.setPostalCode(dto.getPostalCode());
        publication.setStreet(dto.getStreet());
        publication.setDescription(dto.getDescription());
        publication.setIllustrations(dto.getIllustrations());

        return publicationRepository.save(publication);
    }

    @Override
    public Publication manageLikes(PublicationUpdateLikesDto dto) {
        Publication publication = publicationRepository.findById(dto.getPublicationId())
                .orElseThrow(() -> new RuntimeException("Publication not found"));

        if (dto.isAddLike()) {
            publication.getLikes().add(dto.getUserId());
        } else {
            publication.getLikes().remove(dto.getUserId());
        }

        publication.getLikes().size();

        return publication;
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

    @Override
    public List<PublicationGetDto> getUserPublications(long id) {
        List<Publication> publications = publicationRepository.findPublicationsWithAuthorByAuthorId(id);

        return publications.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicationGetDto> fetchAll() {
        List<Publication> publications = publicationRepository.findAll();

        return publications.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public PublicationGetDto mapToDto(Publication pub) {
        PublicationGetDto dto = new PublicationGetDto();

        dto.setId(pub.getId());
        dto.setTitle(pub.getTitle());
        dto.setCategory(pub.getCategory());
        dto.setCity(pub.getCity());
        dto.setPostalCode(pub.getPostalCode());
        dto.setStreet(pub.getStreet());
        dto.setLatitude(pub.getLatitude());
        dto.setLongitude(pub.getLongitude());
        dto.setDescription(pub.getDescription());
        dto.setIllustrations(pub.getIllustrations());
        dto.setLikes(pub.getLikes());
        dto.setPublicationDate(pub.getPublicationDate());

        Subscriber author = pub.getAuthor();
        PublicationAuthorDto authorDto = new PublicationAuthorDto(
                author.getId(),
                author.getFirstname(),
                author.getLastname(),
                author.getPseudonym(),
                author.getPicture()
        );
        dto.setAuthor(authorDto);

        return dto;
    }

    ////////////////////// Setters ////////////////////////////

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Autowired
    public void setGeocodingService(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }
}
