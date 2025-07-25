package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.CommentEvent;
import com.hello.neighbors.entity.CommentPublication;
import com.hello.neighbors.entity.dto.CommentCreateDto;
import com.hello.neighbors.entity.dto.CommentDeleteDto;
import com.hello.neighbors.entity.dto.CommentGetDto;
import com.hello.neighbors.entity.dto.CommentUpdateDto;
import com.hello.neighbors.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/hello/neighbors/comment")
@CrossOrigin("${front.url}")
public class CommentRestController {

    private CommentService commentService;

    //////////////// Endpoints ////////////////

    @PostMapping("/post/publication/comment")
    public ResponseEntity<CommentGetDto> postPublicationComment(@RequestBody CommentCreateDto dto) {
        CommentGetDto comment = commentService.createPublicationComment(dto);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/post/event/comment")
    public ResponseEntity<CommentGetDto> postEventComment(@RequestBody CommentCreateDto dto) {
        CommentGetDto comment = commentService.createEventComment(dto);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentGetDto> updateComment(@RequestBody CommentUpdateDto dto) {
        CommentGetDto comment = commentService.update(dto);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestBody CommentDeleteDto dto) {
        commentService.delete(dto);
    }

    @GetMapping("/publication/{id}/associated/comments")
    public List<CommentGetDto> getPublicationAssociatedComments(@PathVariable long id) {
        return commentService.getPublicationAssociatedComments(id);
    }

    @GetMapping("/event/{id}/associated/comments")
    public List<CommentGetDto> getEventAssociatedComments(@PathVariable long id) {
        return commentService.getEventAssociatedComments(id);
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
