package com.hello.neighbors.controller.rest;

import com.hello.neighbors.entity.Comment;
import com.hello.neighbors.entity.Publication;
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

    @PostMapping("/publish")
    public ResponseEntity<Comment> publishComment(@RequestBody CommentCreateDto dto) {
        Comment comment = commentService.create(dto);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentUpdateDto dto) {
        Comment comment = commentService.update(dto);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestBody CommentDeleteDto dto) {
        commentService.delete(dto);
    }

    @GetMapping("{id}/associated/comments")
    public List<CommentGetDto> getAssociatedComments(@PathVariable long postId) {
        return commentService.getAssociatedComments(postId);
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
