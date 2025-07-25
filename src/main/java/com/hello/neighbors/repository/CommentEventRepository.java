package com.hello.neighbors.repository;

import com.hello.neighbors.entity.CommentEvent;
import com.hello.neighbors.entity.Event;
import com.hello.neighbors.entity.dto.CommentGetDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentEventRepository extends JpaRepository<CommentEvent, Long> {

    List<CommentEvent> findByEventId(long postId);

    List<CommentEvent> findByEvent(Event event);

    List<CommentEvent> findByParentComment(CommentEvent comment);
}
