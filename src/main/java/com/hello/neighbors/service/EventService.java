package com.hello.neighbors.service;

import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.EventCancelDto;
import com.hello.neighbors.entity.dto.EventCreateDto;
import com.hello.neighbors.entity.dto.EventUpdateDto;
import com.hello.neighbors.entity.dto.EventUpdateParticipantsDto;

public interface EventService {

    Event create(EventCreateDto dto);
    Event update(EventUpdateDto dto);
    Event join(EventUpdateParticipantsDto dto);
    void cancel(EventCancelDto dto);
}
