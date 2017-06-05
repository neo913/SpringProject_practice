package com.testweb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="article_id")
	private Article article;
	
	@OneToOne
	private Account writer;

	private String content;

	private Date writeTime = new Date();

	public Article getArticle() {
		return article;
	}

	public String getContent() {
		return content;
	}

	public Long getId() {
		return id;
	}

	public Account getWriter() {
		return writer;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setWriter(Account writer) {
		this.writer = writer;
	}
	
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
}
