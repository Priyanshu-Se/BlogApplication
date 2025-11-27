package com.jsp.demo.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.demo.daoInterfaces.LikeDao;
import com.jsp.demo.daoInterfaces.PostDao;
import com.jsp.demo.daoInterfaces.UserDao;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Like;
import com.jsp.demo.entity.Post;
import com.jsp.demo.entity.User;
import com.jsp.demo.serviceInterfaces.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDao likeDao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private PostDao postDao;

	@Override
	public ResponseStructure saveLike(Like like, String username, int postId) {

		User user = userdao.findUserByUserName(username);
		Post post = postDao.findPostById(postId);

		like.setPost(post);
		like.setUser(user);

		likeDao.saveLike(like);

		return new ResponseStructure(200, "Like is added for the post in the db", null, LocalDateTime.now());

	}

	@Override
	public ResponseStructure delete(int postId, String username) {
		userdao.findUserByUserName(username);
		postDao.findPostById(postId);

		likeDao.deleteLike(postId, username);
		return new ResponseStructure(200, "Like is deleted for the post in the db", null, LocalDateTime.now());

	}

}
