package com.testweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.testweb.model.Account;
import com.testweb.model.Article;
import com.testweb.repository.ArticleRepositoryJpa;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepositoryJpa articleRepositoryJpa;
	
	public List<Article> findAllArticles() {
		Sort desc = new Sort(Sort.Direction.DESC, "writeTime");
		return articleRepositoryJpa.findAll(desc);
	}
	
	public Article findArticleById(Long id) {
		return articleRepositoryJpa.findOne(id);
	}

	public void createArticle(String title, String content, Account writer) {
		Article newArticle = new Article(title, content, writer);
		articleRepositoryJpa.saveAndFlush(newArticle);
	}

	public void updateArticle(Article article) {
		Article target = articleRepositoryJpa.findOne(article.getId());
		target = article;
		articleRepositoryJpa.saveAndFlush(target);
	}
	
	public void deleteArticleById(Long id) {
		articleRepositoryJpa.delete(id);
	}
}
