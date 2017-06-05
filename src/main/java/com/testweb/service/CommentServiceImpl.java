package com.testweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testweb.repository.CommentRepositoryJpa;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepositoryJpa commentRepositoryJpa;
	
}
