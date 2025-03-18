package com.dto;

public class CommentDto {
	private Long id;
	
	private String text;
	
	private Long blogId;
	
	

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
