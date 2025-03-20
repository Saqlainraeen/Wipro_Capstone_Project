package com.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BlogDto;
import com.entity.BlogEntity;
import com.exceptions.ResourceNotFoundException;
import com.repository.BlogRepository;
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    // Convert Entity to DTO
    private BlogDto mapEntityToDto(BlogEntity blogEntity) {
        BlogDto blogDto = new BlogDto();
        blogDto.setId(blogEntity.getId());
        blogDto.setTitle(blogEntity.getTitle());
        blogDto.setContent(blogEntity.getContent());
        return blogDto;
    }

    // Convert DTO to Entity
    private BlogEntity mapDtoToEntity(BlogDto blogDto) {
        BlogEntity blogEntity = new BlogEntity();
        blogEntity.setId(blogDto.getId());
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());
        return blogEntity;
    }

    // Create Blog
    public BlogDto createBlog(BlogDto blogDto) {
        BlogEntity blogEntity = mapDtoToEntity(blogDto);
        BlogEntity savedBlog = blogRepository.save(blogEntity);
        return mapEntityToDto(savedBlog);
    }

    // Get All Blogs
    public List<BlogDto> findAll() {
        return blogRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    // Get Blog By Id
    public BlogDto getBlogById(Long id) {
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with ID: "+id));
        return mapEntityToDto(blog);
    }

    // Update Blog
    public BlogDto updateBlog(Long id, BlogDto blogDto) {
        BlogEntity existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: "+id));
        existingBlog.setTitle(blogDto.getTitle());
        existingBlog.setContent(blogDto.getContent());
        BlogEntity updatedBlog = blogRepository.save(existingBlog);
        return mapEntityToDto(updatedBlog);
    }

    // Delete Blog
    public void deleteBlog(Long id) {    	
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: "+id));
        blogRepository.delete(blog);
    }
}
