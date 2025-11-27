package com.jsp.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.demo.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

	@Modifying
	@Transactional
	@Query("delete from Like l where l.post.id = :postId and l.user.username = :username")
	public void deleteByPostIdAndUserId(@Param("postId") int postId,@Param("username") String username);
	
	@Query("select l from Like l where l.post.id=:postid and l.user.id=:userid")
	public Optional<Like> existsByPostAndUser(@Param("postid") int postId,@Param("userid") int userId);
	
}
