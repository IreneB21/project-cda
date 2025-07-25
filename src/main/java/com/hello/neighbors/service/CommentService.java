package com.hello.neighbors.service;

import com.hello.neighbors.entity.CommentEvent;
import com.hello.neighbors.entity.CommentPublication;
import com.hello.neighbors.entity.dto.CommentCreateDto;
import com.hello.neighbors.entity.dto.CommentDeleteDto;
import com.hello.neighbors.entity.dto.CommentGetDto;
import com.hello.neighbors.entity.dto.CommentUpdateDto;

import java.util.List;

public interface CommentService {

    CommentGetDto update(CommentUpdateDto dto);
    void delete(CommentDeleteDto dto);
    List<CommentGetDto> getPublicationAssociatedComments(long postId);
    List<CommentGetDto> getEventAssociatedComments(long postId);
    CommentGetDto createPublicationComment(CommentCreateDto dto);
    CommentGetDto createEventComment(CommentCreateDto dto);
}
