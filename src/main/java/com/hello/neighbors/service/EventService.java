package com.hello.neighbors.service;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.EventCancelDto;
import com.hello.neighbors.entity.dto.EventCreateDto;
import com.hello.neighbors.entity.dto.EventUpdateDto;
import com.hello.neighbors.entity.dto.EventUpdateLikesDto;
import com.hello.neighbors.entity.dto.EventUpdateParticipantsDto;

import java.util.List;

public interface EventService {

    Event create(EventCreateDto dto);
    Event update(EventUpdateDto dto);
    Event manageParticipation(EventUpdateParticipantsDto dto);
    Event manageLikes(EventUpdateLikesDto dto);
    void cancel(EventCancelDto dto);
    List<Event> fetchAll();
}
