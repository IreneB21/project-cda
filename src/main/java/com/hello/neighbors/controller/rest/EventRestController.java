package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/hello/neighbors/event")
@CrossOrigin("${front.url}")
public class EventRestController {

    private EventService eventService;

    //////////////// Endpoints ////////////////

    @GetMapping("/all/events")
    public List<EventGetDto> getAllEvents() {
        return eventService.fetchAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventCreateDto dto) {
        Event event = eventService.create(dto);
        return ResponseEntity.ok(event);
    }

    @PatchMapping("/update")
    public ResponseEntity<EventGetDto> updateEvent(@RequestBody EventUpdateDto dto) {
        EventGetDto event = eventService.update(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/join")
    public ResponseEntity<EventDto> join(@RequestBody EventUpdateParticipantsDto dto) {
        Event event = eventService.manageParticipation(dto);
        return ResponseEntity.ok(EventDto.from(event));
    }

    @PutMapping("/leave")
    public ResponseEntity<EventDto> leave(@RequestBody EventUpdateParticipantsDto dto) {
        Event event = eventService.manageParticipation(dto);
        return ResponseEntity.ok(EventDto.from(event));
    }

    @PutMapping("/like")
    public ResponseEntity<EventDto> like(@RequestBody EventUpdateLikesDto dto) {
        Event event = eventService.manageLikes(dto);
        return ResponseEntity.ok(EventDto.from(event));
    }

    @PutMapping("/dislike")
    public ResponseEntity<EventDto> dislike(@RequestBody EventUpdateLikesDto dto) {
        Event event = eventService.manageLikes(dto);
        return ResponseEntity.ok(EventDto.from(event));
    }

    @GetMapping("/user/{id}/events")
    public List<EventGetDto> getUserEvents(@PathVariable long id) {
        return eventService.getUserEvents(id);
    }

    @DeleteMapping("/cancel")
    public boolean cancelEvent(@RequestBody EventCancelDto dto) {
        return eventService.cancel(dto);
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
