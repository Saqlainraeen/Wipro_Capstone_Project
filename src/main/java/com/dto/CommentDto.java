package com.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentDto {
	private Long id;
	
	@NotBlank(message="Comment cannot be empty")
	@Size(min=3,max=200,message="Comment must 3-200 characters")
	private String text;
	@NotNull(message="blogId cannot be Null")
	private Long blogId;
	private LocalDateTime createdAt;
	public CommentDto(Long id, String text, Long blogId) {
		super();
		this.id = id;
		this.text = text;
		this.blogId = blogId;
	}
	

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	
	

}
