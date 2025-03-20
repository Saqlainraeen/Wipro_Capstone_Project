package com.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BlogDto;
import com.dto.CommentDto;
import com.entity.BlogEntity;
import com.entity.CommentEntity;
import com.exceptions.ResourceNotFoundException;
import com.repository.BlogRepository;
import com.repository.CommentRepository;
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    // Convert Entity to DTO
    private CommentDto mapEntityToDto(CommentEntity commentEntity) {
        return new CommentDto(commentEntity.getId(), commentEntity.getText(), commentEntity.getBlog().getId());
    }

    // Convert DTO to Entity
    private CommentEntity mapDtoToEntity(CommentDto commentDto) {
        BlogEntity blog = blogRepository.findById(commentDto.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return new CommentEntity(null, commentDto.getText(), blog);
    }

    // Add Comment
    public CommentDto addComment(CommentDto commentDto) {
        CommentEntity commentEntity = mapDtoToEntity(commentDto);
        CommentEntity savedComment = commentRepository.save(commentEntity);
        return mapEntityToDto(savedComment);
    }
 // Get All Comments
    public List<CommentDto> findAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    // Get Comments by Blog ID
    public List<CommentDto> getCommentsByBlogId(Long blogId) throws ResourceNotFoundException {
        if (!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("Blog not found with ID: " + blogId);
        }
        return commentRepository.findByBlogId(blogId)
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    // Delete Comment by ID
    public void deleteComment(Long id) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        commentRepository.delete(comment);
    }

	
}
