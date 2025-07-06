package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> getByAuthorId(long id);
}
