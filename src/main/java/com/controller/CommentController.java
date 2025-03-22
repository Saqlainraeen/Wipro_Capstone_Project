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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
@Tag(name = "Comment Management", description = "CRUD Operations related to blog comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Add Comment
    @PostMapping
    @Operation(summary = "Add a Comment", description = "Creates a new comment for a blog post.")
    public ResponseEntity<CommentDto> addComment(@Valid@RequestBody CommentDto commentDto) throws Exception {
        return ResponseEntity.ok(commentService.addComment(commentDto));
    }
    //Get All comments
    
    @GetMapping
    @Operation(summary = "View All Comments", description = "Retrieves all comments for a specific blog.")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.findAllComments());
    }
    
    
    
    // Get Comments by Blog ID
    @GetMapping("/blog/{blogId}")
    @Operation(summary = "View All Comments with specific blog ID", description = "Retrieves comments for a specific blog.")
    public ResponseEntity<List<CommentDto>> getCommentsByBlogId(@PathVariable Long blogId) throws Exception {
        return ResponseEntity.ok(commentService.getCommentsByBlogId(blogId));
    }

    // Delete Comment by ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Comment", description = "Deletes a comment by its ID.")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) throws Exception {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
	

