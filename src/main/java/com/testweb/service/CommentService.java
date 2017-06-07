package com.testweb.service;

import com.testweb.model.Account;
import com.testweb.model.Article;

public interface CommentService {

	void addComment(Article article, Account writer, String content);
}
