package com.testweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="article_id")
	private Long id;
	
	private String title;
	
	@Column(length=3000)
	private String content;

	@OneToOne(cascade=CascadeType.MERGE)
	private Account writer;

	private Date writeTime = new Date();
	
	@OneToMany(mappedBy="article", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Comment> comments = new ArrayList<Comment>();

	public Article(){
		this.title = "";
		this.content = "";
		this.writer = new Account();
		this.writeTime = new Date();
		this.comments = new ArrayList<Comment>();
	}
	
	public Article(String title, String content, Account writer){
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeTime = new Date();
		this.comments = new ArrayList<Comment>();
	}

	// This function as a problem
	public void updateArticle(Article art){
		this.setTitle(art.getTitle());
		this.setContent(art.getContent());
		this.setWriter(art.getWriter());
		this.setWriteTime(art.getWriteTime());
		this.comments = new ArrayList<Comment>();
		comments.addAll(art.getComments());
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public String getContent() {
		return content;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Account getWriter() {
		return writer;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(Account writer) {
		this.writer = writer;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	
}
