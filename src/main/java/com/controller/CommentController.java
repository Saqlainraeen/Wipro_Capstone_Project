package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CommentEntity;
import com.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	private final CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService=commentService;
	}
	@PostMapping("/{blogId}")
	public ResponseEntity<CommentEntity>addComment(@PathVariable Long blogId,@RequestBody CommentEntity comment) throws Exception{
		return new ResponseEntity<>(commentService.addComment(blogId,comment),HttpStatus.CREATED);
	}
	
	@GetMapping("/blog/{blogId}")
	public ResponseEntity<List<CommentEntity>>getCommentByBlogId(@PathVariable Long blogId) throws Exception{
		return ResponseEntity.ok(commentService.getCommentByBlogId(blogId));
	}
	
}
