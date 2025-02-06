package com.example.demo.comment.controller;

import com.example.demo.comment.dto.CommentDTO;
import com.example.demo.comment.dto.CommentResponseDTO;
import com.example.demo.comment.model.Comment;
import com.example.demo.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody CommentDTO commentDTO) {

        Comment savedComment = commentService.createComment(commentDTO);

        return ResponseEntity.ok(savedComment);
    }

    @GetMapping
    public ResponseEntity<CommentResponseDTO> getComments(@PathVariable long postId) {

        CommentResponseDTO commentResponseDTO = commentService.findByPostId(postId);
        return ResponseEntity.ok(commentResponseDTO);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable long commentId, @RequestBody CommentDTO commentDTO) {

        commentService.updateComment(commentId, commentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable long commentId) {

        return ResponseEntity.ok().build();
    }
}
