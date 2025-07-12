package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Comment;
import com.hello.neighbors.entity.dto.CommentGetDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<CommentGetDto> findByPublicationId(long postId);
}
