package com.testweb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testweb.model.Account;
import com.testweb.model.Article;
import com.testweb.model.Comment;
import com.testweb.repository.ArticleRepositoryJpa;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepositoryJpa articleRepositoryJpa;
	
	public List<Article> findAllArticles() {
		return articleRepositoryJpa.findAll();
	}

	public Article findArticleById(Long id) {
		return articleRepositoryJpa.findOne(id);
	}

	public void createArticle(String title, String content, Account writer) {
		Article newArticle = new Article(title, content, writer);
		articleRepositoryJpa.saveAndFlush(newArticle);
	}

}
