package com.testweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testweb.model.Comment;

@Repository("commentRepository")
public interface CommentRepositoryJpa extends JpaRepository<Comment, Long>{

}
