package com.hello.neighbors.service;

import com.hello.neighbors.entity.Comment;
import com.hello.neighbors.entity.dto.CommentCreateDto;
import com.hello.neighbors.entity.dto.CommentDeleteDto;
import com.hello.neighbors.entity.dto.CommentUpdateDto;

public interface CommentService {

    Comment create(CommentCreateDto dto);
    Comment update(CommentUpdateDto dto);
    void delete(CommentDeleteDto dto);
}
