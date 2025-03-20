package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDto;
import com.dto.CommentDto;
import com.entity.CommentEntity;
import com.exceptions.ResourceNotFoundException;
import com.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Add Comment
    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.addComment(commentDto));
    }
    //Get All comments
    
    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.findAllComments());
    }
    
    
    
    // Get Comments by Blog ID
    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<CommentDto>> getCommentsByBlogId(@PathVariable Long blogId) throws Exception {
        return ResponseEntity.ok(commentService.getCommentsByBlogId(blogId));
    }

    // Delete Comment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
	

