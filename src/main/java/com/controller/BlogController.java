package com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDto;
import com.entity.BlogEntity;
import com.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/blogs")
@Tag(name="Blog Management",description="CRUD Operation related to Blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // Create Blog
    
    @PostMapping
    @Operation(summary = "Create a New Blog", description = "Add a new blog post to the system.")
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.createBlog(blogDto));
    }

    // Get All Blogs
    @GetMapping
    @Operation(summary = "Get All Blogs", description = "Retrieve a list of all blog posts.")
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return ResponseEntity.ok(blogService.findAll());
    }

    // Get Blog by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get Blog by ID", description = "Retrieve a specific blog post by its unique ID.")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    // Update Blog
    @PutMapping("/{id}")
    @Operation(summary = "Update Blog", description = "Modify an existing blog post.")
    public ResponseEntity<BlogDto> updateBlog(@PathVariable Long id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogDto));
    }

    // Delete Blog
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Blog", description = "Remove a blog post from the system.")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }
}
	
	


