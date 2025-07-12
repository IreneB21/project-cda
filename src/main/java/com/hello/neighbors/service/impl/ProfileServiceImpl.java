package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.User;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.GeocodingService;
import com.hello.neighbors.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private static final Logger logger = LogManager.getLogger();

    private UserRepository userRepository;
    private GeocodingService geocodingService;
    private PublicationRepository publicationRepository;
    private EventRepository eventRepository;
    private EventServiceImpl eventService;
    private PublicationServiceImpl publicationService;

    ////////////////// Méthodes ////////////////

    @Override
    public ResponseEntity<Object> update(ProfileUpdateDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identifiant déjà utilisé");
        } else {
            Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            existingUser.setLastname(dto.getLastname());
            existingUser.setFirstname(dto.getFirstname());
            existingUser.setPseudonym(dto.getPseudonym());
            existingUser.setPassword(dto.getPassword()); // Consider encoding password
            existingUser.setEmail(dto.getEmail());
            existingUser.setCity(dto.getCity());
            existingUser.setPostalCode(dto.getPostalCode());
            existingUser.setStreet(dto.getStreet());

            Optional<double[]> coordinates = geocodingService.geocodeAddress(
                    dto.getStreet(),
                    dto.getPostalCode(),
                    dto.getCity()
            );
            coordinates.ifPresent(coords -> {
                existingUser.setLatitude(coords[0]);
                existingUser.setLongitude(coords[1]);
            });

            existingUser.setIsInCity(dto.isInCity());
            existingUser.setBirthdate(dto.getBirthdate());
            existingUser.setIntroduction(dto.getIntroduction());
            existingUser.setPhone(dto.getPhone());
            existingUser.setPicture(dto.getPicture());
            existingUser.setNotificationPreferences(dto.getNotificationPreferences());

            return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(existingUser));
        }
    }

    @Override
    public User getUserInfos(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public ResponseEntity<Object> updateBio(ProfileUpdateBioDto dto) {
        logger.info("User ID : " + dto.getUserId());
        Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setIntroduction(dto.getBody());
        logger.info("Présentation : " + dto.getBody());
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(existingUser));
    }

    @Override
    public UserGetForVisitorDto getUserInfosForVisitor(long id) {
        return userRepository.getUserInfosForVisitor(id);
    }

    @Override
    public Map<String, List<?>> getUserPosts(long userId) {
        List<PublicationGetDto> publications = publicationRepository
                .findPublicationsWithAuthorByAuthorId(userId)
                .stream()
                .map(publicationService::mapToDto)
                .collect(Collectors.toList());

        List<EventGetDto> events = eventRepository
                .findEventsWithParticipantsAndAuthorByAuthorId(userId)
                .stream()
                .map(event -> {
                    List<EventParticipantDto> participants = event.getParticipants().stream()
                            .map(sub -> new EventParticipantDto(
                                    sub.getId(),
                                    sub.getFirstname(),
                                    sub.getLastname()))
                            .collect(Collectors.toList());

                    return this.eventService.mapToDto(event, participants);
                })
                .collect(Collectors.toList());

        Map<String, List<?>> result = new HashMap<>();
        result.put("publications", publications);
        result.put("events", events);
        return result;
    }

    ////////////////// Setters ////////////////

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setGeocodingService(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }
    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Autowired
    public void setEventService(EventServiceImpl eventService) {
        this.eventService = eventService;
    }
    @Autowired
    public void setPublicationService(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }
}
