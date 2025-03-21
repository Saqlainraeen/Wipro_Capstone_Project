package com.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="blogs")
public class BlogEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Blog title cannot be empty")
	@Size(min=3,max=100,message="Title must be 3-100 characters")
	private String title;
	
	@NotBlank(message="Blog content cannot be empty")
	@Size(min=3,max=100,message="Content must be 3-100 characters")
	private String content;
	
	@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CommentEntity> comments;
	 
	@Column(name = "created_at", updatable = false, nullable = false)
	@CreationTimestamp
    private LocalDateTime createdAt;
	
	
	 
	public BlogEntity(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public BlogEntity() {
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

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	

	
	
	

}
