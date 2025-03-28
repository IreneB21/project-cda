package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.Comment;
import com.hello.neighbors.entity.Publication;
import com.hello.neighbors.entity.Subscriber;
import com.hello.neighbors.entity.dto.CommentCreateDto;
import com.hello.neighbors.entity.dto.CommentDeleteDto;
import com.hello.neighbors.entity.dto.CommentUpdateDto;
import com.hello.neighbors.repository.CommentRepository;
import com.hello.neighbors.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = LogManager.getLogger();

    private CommentRepository commentRepository;

    @Override
    public Comment create(CommentCreateDto dto) {

        if (dto.getPublicationId() == null && dto.getParentCommentId() == null) {
            throw new IllegalArgumentException("Un commentaire doit être rattaché à une publication ou à un autre commentaire.");
        }
        if (dto.getPublicationId() != null && dto.getParentCommentId() != null) {
            throw new IllegalArgumentException("Un commentaire ne peut pas être rattaché à la fois à une publication et à un autre commentaire.");
        }

        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());
        Publication publication = null;
        if (dto.getPublicationId() != null) {
            publication = new Publication();
            publication.setId(dto.getPublicationId());
        }
        Comment parentComment = null;
        if (dto.getParentCommentId() != null) {
            parentComment = new Comment();
            parentComment.setId(dto.getParentCommentId());
        }

        Comment comment = new Comment(
                dto.getBody(),
                LocalDateTime.now(),
                author,
                publication,
                parentComment,
                false,
                false
        );

        return commentRepository.save(comment);
    }

    @Override
    public Comment update(CommentUpdateDto dto) {

        Comment existingComment = commentRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        existingComment.setBody(dto.getBody());
        existingComment.setModified(true);

        return commentRepository.save(existingComment);
    }

    @Override
    public void delete(CommentDeleteDto dto) {

    }

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
