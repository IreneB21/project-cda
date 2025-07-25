package com.hello.neighbors.service.impl;

import com.hello.neighbors.entity.*;
import com.hello.neighbors.entity.dto.*;
import com.hello.neighbors.repository.CommentEventRepository;
import com.hello.neighbors.repository.CommentPublicationRepository;
import com.hello.neighbors.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = LogManager.getLogger();

    private CommentPublicationRepository commentPublicationRepository;
    private CommentEventRepository commentEventRepository;

    @Override
    @Transactional
    public CommentGetDto createPublicationComment(CommentCreateDto dto) {

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

        return mapToDtoPublication(commentPublicationRepository.save(comment));
    }

    @Override
    @Transactional
    public CommentGetDto createEventComment(CommentCreateDto dto) {

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

        return mapToDtoEvent(commentEventRepository.save(comment));
    }

    @Override
    @Transactional
    public CommentGetDto update(CommentUpdateDto dto) {

        CommentPublication existingComment = commentPublicationRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        existingComment.setBody(dto.getBody());
        existingComment.setModified(true);

        return mapToDtoPublication(commentPublicationRepository.save(existingComment));
    }

    @Override
    @Transactional
    public void delete(CommentDeleteDto dto) {
        Optional<CommentPublication> commentToDelete = commentPublicationRepository.findById(dto.getCommentId());
        if (commentToDelete.isEmpty()) {
            logger.info("Comment not find with ID " + dto.getCommentId());
        }
        commentPublicationRepository.deleteById(dto.getCommentId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentGetDto> getPublicationAssociatedComments(long postId) {
        List<CommentPublication> comments = commentPublicationRepository.findByPublicationId(postId);

        return comments.stream()
                .map(this::mapToDtoPublication)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentGetDto> getEventAssociatedComments(long postId) {
        List<CommentEvent> comments = commentEventRepository.findByEventId(postId);

        return comments.stream()
                .map(this::mapToDtoEvent)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteEventCommentCascade(CommentEvent comment) {
        List<CommentEvent> children = commentEventRepository.findByParentComment(comment);

        for (CommentEvent child : children) {
            deleteEventCommentCascade(child);
        }

        commentEventRepository.delete(comment);
    }

    @Transactional
    public void deletePublicationCommentCascade(CommentPublication comment) {
        List<CommentPublication> children = commentPublicationRepository.findByParentComment(comment);

        for (CommentPublication child : children) {
            deletePublicationCommentCascade(child);
        }

        commentPublicationRepository.delete(comment);
    }

    private CommentGetDto mapToDtoEvent(CommentEvent comment) {
        CommentGetDto dto = new CommentGetDto();

        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setAuthor(mapToAuthorDto(comment.getAuthor()));
        dto.setParentId(comment.getEvent() != null ? comment.getEvent().getId() : null);
        dto.setParentCommentId(comment.getParentComment() != null ? comment.getParentComment().getId() : null);

        return dto;
    }

    private CommentGetDto mapToDtoPublication(CommentPublication comment) {
        CommentGetDto dto = new CommentGetDto();

        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setAuthor(mapToAuthorDto(comment.getAuthor()));
        dto.setParentId(comment.getPublication() != null ? comment.getPublication().getId() : null);
        dto.setParentCommentId(comment.getParentComment() != null ? comment.getParentComment().getId() : null);

        return dto;
    }

    private AuthorDto mapToAuthorDto(Subscriber author) {
        if (author == null) return null;

        return new AuthorDto(
                author.getId(),
                author.getFirstname(),
                author.getLastname(),
                author.getPseudonym(),
                author.getPicture()
        );
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
