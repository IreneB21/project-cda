package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.EventCancelDto;
import com.hello.neighbors.entity.dto.EventCreateDto;
import com.hello.neighbors.entity.dto.EventUpdateDto;
import com.hello.neighbors.entity.dto.EventUpdateLikesDto;
import com.hello.neighbors.entity.dto.EventUpdateParticipantsDto;
import com.hello.neighbors.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/hello/neighbors/event")
@CrossOrigin("${front.url}")
public class EventRestController {

    private EventService eventService;

    //////////////// Endpoints ////////////////

    @GetMapping("/all/events")
    public List<Event> getAllEvents() {
        return eventService.fetchAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventCreateDto dto) {
        Event event = eventService.create(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody EventUpdateDto dto) {
        Event event = eventService.update(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/join")
    public ResponseEntity<Event> join(@RequestBody EventUpdateParticipantsDto dto) {
        Event event = eventService.manageParticipation(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/leave")
    public ResponseEntity<Event> leave(@RequestBody EventUpdateParticipantsDto dto) {
        Event event = eventService.manageParticipation(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/like")
    public ResponseEntity<Event> like(@RequestBody EventUpdateLikesDto dto) {
        Event event = eventService.manageLikes(dto);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/dislike")
    public ResponseEntity<Event> dislike(@RequestBody EventUpdateLikesDto dto) {
        Event event = eventService.manageLikes(dto);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/cancel")
    public void cancelEvent(@RequestBody EventCancelDto dto) {
        eventService.cancel(dto);
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
