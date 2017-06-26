package com.testweb.service;

import java.util.List;

import com.testweb.model.Account;
import com.testweb.model.Article;
import com.testweb.model.Comment;

public interface CommentService {

	List<Comment> findAllCommentsByArticleId(Long id);
	
	Comment findCommentById(Long id);
	
	void addComment(Article article, Account writer, String content);
	
	void updateComment(Comment comment);
	
	void deleteCommentById(Long id);
}
