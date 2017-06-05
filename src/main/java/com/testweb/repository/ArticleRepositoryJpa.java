package com.testweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testweb.model.Article;

@Repository("articleRepository")
public interface ArticleRepositoryJpa extends JpaRepository<Article, Long>{

/*	@Query("Select a.id, a.title, a.content, a.writer, a.writeTime"
			+ "(Select count(*) from comment c where c.article.id = a.id)"
			+ "From Article a Order By desc")
	List<Article> findAllArticles();*/
}
