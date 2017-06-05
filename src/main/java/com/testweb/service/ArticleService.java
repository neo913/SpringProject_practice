package com.testweb.service;

import java.util.List;

import com.testweb.model.Account;
import com.testweb.model.Article;

public interface ArticleService {

	Article findArticleById(Long id);
	
	List<Article> findAllArticles();
	
	void createArticle(String title, String content, Account writer);
}
