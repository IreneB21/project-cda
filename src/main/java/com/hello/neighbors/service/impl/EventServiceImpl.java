package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.EventCancelDto;
import com.hello.neighbors.entity.dto.EventCreateDto;
import com.hello.neighbors.entity.dto.EventUpdateDto;
import com.hello.neighbors.entity.dto.EventUpdateLikesDto;
import com.hello.neighbors.entity.dto.EventUpdateParticipantsDto;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.EventService;
import com.hello.neighbors.service.GeocodingService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private static final Logger logger = LogManager.getLogger();

    private EventRepository eventRepository;
    private UserRepository userRepository;
    private GeocodingService geocodingService;

    @Override
    public Event create(EventCreateDto dto) {
        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());
        Event event = new Event();

        event.setTitle(dto.getTitle());
        event.setCity(dto.getCity());
        event.setPostalCode(dto.getPostalCode());
        event.setStreet(dto.getStreet());

        Optional<double[]> coordinates = geocodingService.geocodeAddress(
                dto.getStreet(),
                dto.getPostalCode(),
                dto.getCity()
        );
        coordinates.ifPresent(coords -> {
            event.setLatitude(coords[0]);
            event.setLongitude(coords[1]);
        });

        event.setStartDate(dto.getStartDate());
        event.setEndDate(dto.getEndDate());
        event.setDescription(dto.getDescription());
        event.setIllustrations(dto.getIllustrations());
        event.setAuthor(author);

        //author.getEvents().add(event);
        return eventRepository.save(event);
    }

    @Override
    public Event update(EventUpdateDto dto) {
        Event existingEvent = eventRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        existingEvent.setTitle(dto.getTitle());
        existingEvent.setCity(dto.getCity());
        existingEvent.setPostalCode(dto.getPostalCode());
        existingEvent.setStreet(dto.getStreet());
        existingEvent.setStartDate(dto.getStartDate());
        existingEvent.setEndDate(dto.getEndDate());
        existingEvent.setDescription(dto.getDescription());
        existingEvent.setIllustrations(dto.getIllustrations());

        return eventRepository.save(existingEvent);
    }

    @Override
    public Event manageParticipation(EventUpdateParticipantsDto dto) {
        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        Subscriber participant = (Subscriber) userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Subscriber not found"));

        if (dto.isJoin()) {
            event.getParticipants().add(participant);
        } else {
            event.getParticipants().remove(participant);
        }

        return eventRepository.save(event);
    }

    @Override
    public Event manageLikes(EventUpdateLikesDto dto) {
        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (dto.isAddLike()) {
            event.getLikes().add(dto.getUserId());
        } else {
            event.getLikes().remove(dto.getUserId());
        }

        return eventRepository.save(event);
    }

    @Override
    public void cancel(EventCancelDto dto) {
        Optional<Event> eventToCancel = eventRepository.findById(dto.getEventId());
        if (eventToCancel.isEmpty()) {
            logger.info("Event not find with ID :" + dto.getEventId());
        }
        eventRepository.deleteById(dto.getEventId());
    }

    @Override
    public List<Event> fetchAll() {
        return eventRepository.findAll();
    }

    ////////////////////// Setters ////////////////////////////

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setGeocodingService(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }
}
