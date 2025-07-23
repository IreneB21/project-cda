package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.*;
import com.hello.neighbors.entity.dto.CommentCreateDto;
import com.hello.neighbors.entity.dto.CommentDeleteDto;
import com.hello.neighbors.entity.dto.CommentGetDto;
import com.hello.neighbors.entity.dto.CommentUpdateDto;
import com.hello.neighbors.repository.CommentEventRepository;
import com.hello.neighbors.repository.CommentPublicationRepository;
import com.hello.neighbors.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = LogManager.getLogger();

    private CommentPublicationRepository commentPublicationRepository;
    private CommentEventRepository commentEventRepository;

    @Override
    public CommentPublication createPublicationComment(CommentCreateDto dto) {

        if (dto.getParentId() == null && dto.getParentCommentId() == null) {
            throw new IllegalArgumentException("Un commentaire doit être rattaché à une publication ou à un autre commentaire.");
        }
        if (dto.getParentId() != null && dto.getParentCommentId() != null) {
            throw new IllegalArgumentException("Un commentaire ne peut pas être rattaché à la fois à une publication et à un autre commentaire.");
        }

        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());
        Publication publication = null;
        if (dto.getParentId() != null) {
            publication = new Publication();
            publication.setId(dto.getParentId());
        }
        CommentPublication parentComment = null;
        if (dto.getParentCommentId() != null) {
            parentComment = new CommentPublication();
            parentComment.setId(dto.getParentCommentId());
        }

        CommentPublication comment = new CommentPublication(
                dto.getBody(),
                LocalDateTime.now(),
                author,
                publication,
                parentComment,
                false,
                false
        );

        return commentPublicationRepository.save(comment);
    }

    @Override
    public CommentEvent createEventComment(CommentCreateDto dto) {

        if (dto.getParentId() == null && dto.getParentCommentId() == null) {
            throw new IllegalArgumentException("Un commentaire doit être rattaché à une publication ou à un autre commentaire.");
        }
        if (dto.getParentId() != null && dto.getParentCommentId() != null) {
            throw new IllegalArgumentException("Un commentaire ne peut pas être rattaché à la fois à une publication et à un autre commentaire.");
        }

        Subscriber author = new Subscriber();
        author.setId(dto.getAuthorId());
        Event event = null;
        if (dto.getParentId() != null) {
            event = new Event();
            event.setId(dto.getParentId());
        }
        CommentEvent parentComment = null;
        if (dto.getParentCommentId() != null) {
            parentComment = new CommentEvent();
            parentComment.setId(dto.getParentCommentId());
        }

        CommentEvent comment = new CommentEvent(
                dto.getBody(),
                LocalDateTime.now(),
                author,
                event,
                parentComment,
                false,
                false
        );

        return commentEventRepository.save(comment);
    }

    @Override
    public CommentPublication update(CommentUpdateDto dto) {

        CommentPublication existingComment = commentPublicationRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        existingComment.setBody(dto.getBody());
        existingComment.setModified(true);

        return commentPublicationRepository.save(existingComment);
    }

    @Override
    public void delete(CommentDeleteDto dto) {
        Optional<CommentPublication> commentToDelete = commentPublicationRepository.findById(dto.getCommentId());
        if (commentToDelete.isEmpty()) {
            logger.info("Comment not find with ID " + dto.getCommentId());
        }
        commentPublicationRepository.deleteById(dto.getCommentId());
    }

    @Override
    public List<CommentGetDto> getPublicationAssociatedComments(long postId) {
        List<CommentGetDto> comments = commentPublicationRepository.findByPublicationId(postId);
        return comments;
    }

    @Override
    public List<CommentGetDto> getEventAssociatedComments(long postId) {
        List<CommentGetDto> comments = commentEventRepository.findByEventId(postId);
        return comments;
    }

    public void deleteEventCommentCascade(CommentEvent comment) {
        List<CommentEvent> children = commentEventRepository.findByParentComment(comment);

        for (CommentEvent child : children) {
            deleteEventCommentCascade(child);
        }

        commentEventRepository.delete(comment);
    }

    public void deletePublicationCommentCascade(CommentPublication comment) {
        List<CommentPublication> children = commentPublicationRepository.findByParentComment(comment);

        for (CommentPublication child : children) {
            deletePublicationCommentCascade(child);
        }

        commentPublicationRepository.delete(comment);
    }

    @Autowired
    public void setCommentPublicationRepository(CommentPublicationRepository commentPublicationRepository) {
        this.commentPublicationRepository = commentPublicationRepository;
    }
    @Autowired
    public void setCommentEventRepository(CommentEventRepository commentEventRepository) {
        this.commentEventRepository = commentEventRepository;
    }
}
