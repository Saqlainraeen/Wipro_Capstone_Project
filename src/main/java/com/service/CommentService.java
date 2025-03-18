package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BlogEntity;
import com.entity.CommentEntity;
import com.exceptions.ResourceNotFoundException;
import com.repository.BlogRepository;
import com.repository.CommentRepository;
@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	public CommentEntity addComment(Long blogId,CommentEntity comment) throws Exception {
		Optional<BlogEntity> blog=blogRepository.findById(blogId);
		if(!blog.isPresent()) {
			throw new ResourceNotFoundException("Blog with ID"+blogId+"not found");
		}
		comment.setBlogEntity(blog.get());
		return commentRepository.save(comment);
	}
	public List<CommentEntity>getCommentByBlogId(Long blogId) throws Exception {
		if(!blogRepository.existsById(blogId)) {
			throw new ResourceNotFoundException("Blog with ID"+blogId+"not Found");
		}
		return commentRepository.findByBlogId(blogId);
	}
	
}
