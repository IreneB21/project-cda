package com.hello.neighbors.repository;

import com.hello.neighbors.entity.CommentPublication;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.dto.CommentGetDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentPublicationRepository extends JpaRepository<CommentPublication, Long> {

    List<CommentPublication> findByPublicationId(long postId);

    List<CommentPublication> findByPublication(Publication publication);

    List<CommentPublication> findByParentComment(CommentPublication comment);
}
