package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.PublicationRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.HomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    ////////////////// Methods ////////////////

    @Override
    @Transactional
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

    @Override
    @Transactional
    public Map<String, List<PostDto>> getNearbyPublicationsAndEvents(long userId) {
        UserLocationInfoDto locationInfo = userRepository.findLocationInfoById(userId);
        double lat = locationInfo.getLatitude();
        double lng = locationInfo.getLongitude();
        boolean isInCity = locationInfo.getIsInCity();
        double radiusKm = isInCity ? 2.0 : 15.0;

        List<Publication> publicationsEntities = publicationRepository.findAllWithinRadius(lat, lng, radiusKm);
        List<PublicationGetDto> publications = new ArrayList<>();
        for (Publication pub : publicationsEntities) {
            Hibernate.initialize(pub.getIllustrations());
            Hibernate.initialize(pub.getLikes());
            if (pub.getAuthor() != null) {
                Hibernate.initialize(pub.getAuthor());
            }
            PublicationGetDto dto = publicationService.mapToDto(pub);
            publications.add(dto);
        }

        List<Event> eventEntities = eventRepository.findAllWithinRadius(lat, lng, radiusKm);
        List<EventGetDto> events = new ArrayList<>();
        for (Event ev : eventEntities) {
            Hibernate.initialize(ev.getIllustrations());
            Hibernate.initialize(ev.getLikes());
            if (ev.getAuthor() != null) {
                Hibernate.initialize(ev.getAuthor());
            }
            Hibernate.initialize(ev.getParticipants());
            List<EventParticipantDto> participants = ev.getParticipants()
                    .stream()
                    .map(p -> new EventParticipantDto(p.getId(), p.getFirstname(), p.getLastname()))
                    .collect(Collectors.toList());
            EventGetDto dto = eventService.mapToDto(ev, participants);
            events.add(dto);
        }

        Map<String, List<PostDto>> result = new HashMap<>();
        result.put("publications", new ArrayList<PostDto>(publications));
        result.put("events", new ArrayList<PostDto>(events));

        return result;
    }

    @Override
    @Transactional
    public List<EventGetDto> getNextThreeNearbyEvents(long userId) {
        UserLocationInfoDto locationInfo = userRepository.findLocationInfoById(userId);
        double lat = locationInfo.getLatitude();
        double lng = locationInfo.getLongitude();
        boolean isInCity = locationInfo.getIsInCity();
        double radiusKm = isInCity ? 2.0 : 15.0;

        List<Event> eventEntities = eventRepository.findNext3EventsWithinRadius(lat, lng, radiusKm);
        List<EventGetDto> events = new ArrayList<>();
        for (Event ev : eventEntities) {
            Hibernate.initialize(ev.getIllustrations());
            Hibernate.initialize(ev.getLikes());
            if (ev.getAuthor() != null) {
                Hibernate.initialize(ev.getAuthor());
            }
            Hibernate.initialize(ev.getParticipants());
            List<EventParticipantDto> participants = ev.getParticipants()
                    .stream()
                    .map(p -> new EventParticipantDto(p.getId(), p.getFirstname(), p.getLastname()))
                    .collect(Collectors.toList());
            EventGetDto dto = eventService.mapToDto(ev, participants);
            events.add(dto);
        }
        return events;
    }

    @Override
    public Long getTotalUsersAround(long userId) {
        UserLocationInfoDto locationInfo = userRepository.findLocationInfoById(userId);
        double lat = locationInfo.getLatitude();
        double lng = locationInfo.getLongitude();
        boolean isInCity = locationInfo.getIsInCity();
        double radiusKm = isInCity ? 2.0 : 15.0;

        return userRepository.calculateTotalUsersWithinRadius(lat, lng, radiusKm, userId);
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
