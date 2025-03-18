package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BlogEntity;
import com.exceptions.ResourceNotFoundException;
import com.repository.BlogRepository;
@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	
	public BlogEntity createBlog(BlogEntity blog) {
		return blogRepository.save(blog);
	}
	
	public List<BlogEntity> getAllBlogs(){
		return blogRepository.findAll();
	}
	
	public BlogEntity getBlogById(Long id) throws Exception {
		Optional<BlogEntity>blog=blogRepository.findById(id);
		if (blog.isPresent()) {
			return blog.get();
			
		}else {
			throw new ResourceNotFoundException("Blog with ID"+id+"not found");
		}
	}
	public BlogEntity updateBlog(Long id,BlogEntity updatedBlog) throws Exception {
		BlogEntity existingBlog=getBlogById(id);
		existingBlog.setTitle(updatedBlog.getTitle());
		existingBlog.setContent(updatedBlog.getContent());
		return blogRepository.save(existingBlog);
		
	}
	public void deleteBlog(Long id) throws Exception {
		BlogEntity blog=getBlogById(id);
		blogRepository.delete(blog);
	}

}
