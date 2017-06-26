package com.testweb.service;

import java.util.List;

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

	public List<Comment> findAllCommentsByArticleId(Long id) {
		return commentRepositoryJpa.findAllByArticleIdDesc(id);
	}
	
	public void addComment(Article article, Account writer, String content) {
		Comment newComment = new Comment(article, writer, content);
		commentRepositoryJpa.saveAndFlush(newComment);
	}

	public void deleteCommentById(Long id) {
		commentRepositoryJpa.delete(id);
	}

	public Comment findCommentById(Long id) {
		return commentRepositoryJpa.findOne(id);
	}

	public void updateComment(Comment comment) {
		Comment target = commentRepositoryJpa.findOne(comment.getId());
		target = comment;
		commentRepositoryJpa.saveAndFlush(target);
	}
}
