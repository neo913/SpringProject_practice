package com.testweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testweb.model.Account;
import com.testweb.model.Article;
import com.testweb.model.Comment;
import com.testweb.repository.CommentRepositoryJpa;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepositoryJpa commentRepositoryJpa;

	public void addComment(Article article, Account writer, String content) {
		Comment newComment = new Comment(article, writer, content);
		commentRepositoryJpa.saveAndFlush(newComment);
	}

}
