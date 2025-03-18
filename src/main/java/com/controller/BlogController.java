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

import com.entity.BlogEntity;
import com.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	@GetMapping("/Hello")
	public String Greet() {
		return "Hello Ready for capstone";
		
	}
	private static BlogService blogService;
	
	public BlogController(BlogService blogService) {
		this.blogService=blogService;
	}
	@PostMapping
    public ResponseEntity<BlogEntity> createBlog(@RequestBody BlogEntity blog) {
    return ResponseEntity.ok(blogService.createBlog(blog));
	    }
	@GetMapping
	public ResponseEntity<List<BlogEntity>>getAllBlogs(){
		return ResponseEntity.ok(blogService.getAllBlogs());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<BlogEntity>getBlogById(@PathVariable Long id) throws Exception{
		return ResponseEntity.ok(blogService.getBlogById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BlogEntity>updateBlog(@PathVariable Long id,@RequestBody BlogEntity updatedBlog) throws Exception{
		return ResponseEntity.ok(blogService.updateBlog(id,updatedBlog));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteBlog(@PathVariable Long id) throws Exception{
		blogService.deleteBlog(id);
		return ResponseEntity.ok("Blog deleted successfully.");
		
	}
	
	

}
