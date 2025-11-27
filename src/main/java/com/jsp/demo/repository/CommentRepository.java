package com.jsp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.demo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
