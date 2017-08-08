package com.testweb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.testweb.model.Article;

public interface ArticleService {

	Long countArticles();
	
	Long countPages();
	
	Article findArticleById(Long id);
	
	List<Article> findAllArticles();
	
	Page<Article> findSomeArticles(Pageable page);
	
	void createArticle(Article article);
	
	void updateArticle(Article article);
	
	void deleteArticleById(Long id);
	
}
