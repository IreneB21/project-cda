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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private PasswordEncoder passwordEncoder;

    ////////////////// Methods ////////////////

    @Override
    @Transactional
    public ResponseEntity<Object> update(ProfileUpdateDto dto) {
        Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!existingUser.getEmail().equals(dto.getEmail()) && userRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identifiant déjà utilisé");
        }

        existingUser.setLastname(dto.getLastname());
        existingUser.setFirstname(dto.getFirstname());
        existingUser.setPseudonym(dto.getPseudonym());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

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
        existingUser.setPhone(dto.getPhone());

        userRepository.save(existingUser);

        return ResponseEntity.ok(mapToDto(existingUser));
    }

    @Override
    @Transactional(readOnly = true)
    public SubscriberDto getUserInfos(long id) {
        Subscriber subscriber = (Subscriber) userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapToDto(subscriber);
    }

    @Override
    @Transactional
    public ResponseEntity<ProfileUpdateBioDto> updateBio(ProfileUpdateBioDto dto) {
        logger.info("User ID : " + dto.getUserId());
        Subscriber existingUser = (Subscriber) userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setIntroduction(dto.getBody());
        logger.info("Présentation : " + dto.getBody());

        userRepository.save(existingUser);

        ProfileUpdateBioDto updatedBio = new ProfileUpdateBioDto(
                existingUser.getId(),
                existingUser.getIntroduction()
        );

        return ResponseEntity.status(HttpStatus.OK).body(updatedBio);
    }

    @Override
    @Transactional(readOnly = true)
    public UserGetForVisitorDto getUserInfosForVisitor(long id) {
        return userRepository.getUserInfosForVisitor(id);
    }

    @Override
    @Transactional(readOnly = true)
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

    private SubscriberDto mapToDto(Subscriber subscriber) {
        return new SubscriberDto(
                subscriber.getId(),
                subscriber.getFirstname(),
                subscriber.getLastname(),
                subscriber.getPseudonym(),
                subscriber.getEmail(),
                subscriber.getLatitude(),
                subscriber.getLongitude(),
                subscriber.getCity(),
                subscriber.getPostalCode(),
                subscriber.getStreet(),
                subscriber.getIsInCity(),
                subscriber.getBirthdate(),
                subscriber.getPhone(),
                subscriber.getPicture(),
                subscriber.getRegistrationDate()
        );
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
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
