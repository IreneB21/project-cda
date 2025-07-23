package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.CommentEvent;
import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.repository.CommentEventRepository;
import com.hello.neighbors.repository.EventRepository;
import com.hello.neighbors.repository.UserRepository;
import com.hello.neighbors.service.EventService;
import com.hello.neighbors.service.GeocodingService;
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
public class EventServiceImpl implements EventService {

    private static final Logger logger = LogManager.getLogger();

    private EventRepository eventRepository;
    private CommentEventRepository commentEventRepository;
    private UserRepository userRepository;
    private GeocodingService geocodingService;
    private CommentServiceImpl commentService;

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
        event.setCreationDate(LocalDateTime.now());
        event.setIllustrations(dto.getIllustrations());
        event.setAuthor(author);

        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public EventGetDto update(EventUpdateDto dto) {
        Event existingEvent = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        existingEvent.setTitle(dto.getTitle());
        existingEvent.setCity(dto.getCity());
        existingEvent.setPostalCode(dto.getPostalCode());
        existingEvent.setStreet(dto.getStreet());
        existingEvent.setStartDate(dto.getStartDate());
        existingEvent.setEndDate(dto.getEndDate());
        existingEvent.setDescription(dto.getDescription());
        existingEvent.setIllustrations(dto.getIllustrations());

        Optional<double[]> coordinates = geocodingService.geocodeAddress(
                dto.getStreet(),
                dto.getPostalCode(),
                dto.getCity()
        );

        coordinates.ifPresent(coords -> {
            existingEvent.setLatitude(coords[0]);
            existingEvent.setLongitude(coords[1]);
        });

        eventRepository.save(existingEvent);

        List<EventParticipantDto> participants = existingEvent.getParticipants().stream()
                .map(sub -> new EventParticipantDto(
                        sub.getId(),
                        sub.getFirstname(),
                        sub.getLastname()))
                .collect(Collectors.toList());

        EventGetDto updatedEvent = this.mapToDto(existingEvent, participants);

        return updatedEvent;
    }

    @Transactional
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

        event.getParticipants().size();

        return event;
    }

    @Transactional
    @Override
    public Event manageLikes(EventUpdateLikesDto dto) {
        Event event = eventRepository.findById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (dto.isAddLike()) {
            event.getLikes().add(dto.getUserId());
        } else {
            event.getLikes().remove(dto.getUserId());
        }

        event.getLikes().size();

        return event;
    }

    @Override
    public boolean cancel(EventCancelDto dto) {
        Optional<Event> eventToCancel = eventRepository.findById(dto.getEventId());
        if (eventToCancel.isEmpty()) {
            logger.info("Event not find with ID :" + dto.getEventId());

            return false;
        }

        Event event = eventToCancel.get();
        List<CommentEvent> comments = commentEventRepository.findByEvent(event);
        for (CommentEvent comment : comments) {
            if (comment.getParentComment() == null) {
                commentService.deleteEventCommentCascade(comment);
            }
        }
        eventRepository.delete(event);

        return true;
    }

    @Override
    public List<EventGetDto> getUserEvents(long id) {
        List<Event> events = eventRepository.findEventsWithParticipantsAndAuthorByAuthorId(id);

        return events.stream()
                .map(event -> {
                    List<EventParticipantDto> participants = event.getParticipants().stream()
                            .map(sub -> new EventParticipantDto(
                                    sub.getId(),
                                    sub.getFirstname(),
                                    sub.getLastname()))
                            .collect(Collectors.toList());

                    return mapToDto(event, participants);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EventGetDto> fetchAll() {
        List<Event> events = eventRepository.findAll();

        return events.stream()
                .map(event -> {
                    List<EventParticipantDto> participants = event.getParticipants().stream()
                            .map(sub -> new EventParticipantDto(
                                    sub.getId(),
                                    sub.getFirstname(),
                                    sub.getLastname()))
                            .collect(Collectors.toList());

                    return mapToDto(event, participants);
                })
                .collect(Collectors.toList());
    }

    public EventGetDto mapToDto(Event ev, List<EventParticipantDto> participants) {
        EventGetDto dto = new EventGetDto();

        dto.setId(ev.getId());
        dto.setTitle(ev.getTitle());
        dto.setCity(ev.getCity());
        dto.setPostalCode(ev.getPostalCode());
        dto.setStreet(ev.getStreet());
        dto.setLatitude(ev.getLatitude());
        dto.setLongitude(ev.getLongitude());
        dto.setStartDate(ev.getStartDate());
        dto.setEndDate(ev.getEndDate());
        dto.setDescription(ev.getDescription());
        dto.setIllustrations(ev.getIllustrations());
        dto.setCreationDate(ev.getCreationDate());
        dto.setParticipants(participants);

        Subscriber author = ev.getAuthor();
        EventAuthorDto authorDto = new EventAuthorDto(
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
    @Autowired
    public void setCommentEventRepository(CommentEventRepository commentEventRepository) {
        this.commentEventRepository = commentEventRepository;
    }
    @Autowired
    public void setCommentService(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
}
