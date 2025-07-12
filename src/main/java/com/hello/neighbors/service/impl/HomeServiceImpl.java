package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.EventGetDto;
import com.hello.neighbors.entity.dto.EventParticipantDto;
import com.hello.neighbors.entity.dto.PublicationGetDto;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.HomeService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    private static final Logger logger = LogManager.getLogger();

    private PublicationRepository publicationRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    private EventServiceImpl eventService;
    private PublicationServiceImpl publicationService;

    ////////////////// Méthodes ////////////////

    @Override
    public Map<String, List<?>> getAllPublicationsAndEvents() {
        List<PublicationGetDto> publications = publicationRepository
                .findAll()
                .stream()
                .map(publicationService::mapToDto)
                .collect(Collectors.toList());

        List<EventGetDto> events = eventRepository
                .findAll()
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

    @Transactional
    @Override
    public Map<String, List<?>> getNearbyPublicationsAndEvents(double lat, double lng, double radiusKm) {
        List<PublicationGetDto> publications = publicationRepository
                .findAllWithinRadius(lat, lng, radiusKm)
                .stream()
                .map(publicationService::mapToDto)
                .collect(Collectors.toList());

        List<EventGetDto> events = eventRepository
                .findAllWithinRadius(lat, lng, radiusKm)
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


    @Override
    public List<String> getRandomPictures() {
        return userRepository.fetchRandomPictures();
    }

    ////////////////// Setters ////////////////

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
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
