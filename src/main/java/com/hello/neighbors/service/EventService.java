package com.hello.neighbors.service;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.*;

import java.util.List;

public interface EventService {

    EventGetDto create(EventCreateDto dto);
    EventGetDto update(EventUpdateDto dto);
    Event manageParticipation(EventUpdateParticipantsDto dto);
    Event manageLikes(EventUpdateLikesDto dto);
    boolean cancel(EventCancelDto dto);
    List<EventGetDto> getUserEvents(long id);
    List<EventGetDto> fetchAll();
}
