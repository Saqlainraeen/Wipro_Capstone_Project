package com.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
public class CommentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	 @Column(name = "created_at", updatable = false, nullable = false)
	    @CreationTimestamp
	    private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name="blog_id",nullable=false)
	private BlogEntity blog;

	public CommentEntity(Long id, String text, BlogEntity blog) {
		super();
		this.id = id;
		this.text = text;
		this.blog = blog;
	}

	public CommentEntity() {
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

	public BlogEntity getBlog() {
		return blog;
	}

	public void setBlogEntity(BlogEntity blog) {
		this.blog= blog;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	









}
