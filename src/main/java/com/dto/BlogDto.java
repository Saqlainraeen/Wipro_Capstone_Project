package com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDto {
	private Long id;
	
	@NotBlank(message="Blog title cannot be empty")
	@Size(min=3,max=100,message="Title must be 3-100 characters")
	private String title;
	
	@NotBlank(message="Content cannot be empty")
	@Size(min=3,max=200,message="Content must be 3-100 characters")
	private String content;

	public BlogDto(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public BlogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
