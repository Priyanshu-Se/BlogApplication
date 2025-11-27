package com.jsp.demo.daoImplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.demo.daoInterfaces.LikeDao;
import com.jsp.demo.entity.Like;
import com.jsp.demo.exceptions.EntityAlreadyExistsException;
import com.jsp.demo.repository.LikeRepository;

@Repository
public class LikeDaoImpl implements LikeDao {

	@Autowired
	private LikeRepository repository;

	@Override
	public boolean saveLike(Like like) {
		
		Optional<Like> optional = repository.existsByPostAndUser(like.getPost().getId(), like.getUser().getId());
		optional.ifPresent(l->{
			throw new EntityAlreadyExistsException("Like for the post by the user is already present");
		});
		
		
		
		
		repository.save(like);
		return true;
	}

	@Override
	public boolean deleteLike(int postId, String username) {
		repository.deleteByPostIdAndUserId(postId, username);
		return true;
	}

}
