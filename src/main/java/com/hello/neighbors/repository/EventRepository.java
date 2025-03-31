package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
