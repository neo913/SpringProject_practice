package com.testweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testweb.model.Article;

@Repository("articleRepository")
public interface ArticleRepositoryJpa extends JpaRepository<Article, Long>{

}
