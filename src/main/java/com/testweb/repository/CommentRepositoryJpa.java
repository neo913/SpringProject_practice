package com.testweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testweb.model.Comment;

@Repository("commentRepository")
public interface CommentRepositoryJpa extends JpaRepository<Comment, Long>{

	/*@Query("select c from Comment c where c.article.id = ?1 order by c.writeTime desc")*/
	@Query("select c from Comment c where c.article.id = ?1")
	List<Comment> findAllByArticleIdDesc(Long id);
	
	
}
