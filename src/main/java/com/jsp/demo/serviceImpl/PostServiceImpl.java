package com.jsp.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.demo.daoInterfaces.PostDao;
import com.jsp.demo.daoInterfaces.UserDao;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Post;
import com.jsp.demo.entity.User;
import com.jsp.demo.serviceInterfaces.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseStructure<Post> savePost(Post post, String username) {

		User user = userDao.findUserByUserName(username);
		post.setUser(user);

		post = postDao.savePost(post);


		return new ResponseStructure<>(200, "Post is saved succesfully", post, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Post> deletePostById(int id) {
		postDao.deletePostById(id);
		return new ResponseStructure<>(200, "Post is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Post> fetchPostById(int id) {
		Post post = postDao.findPostById(id);
		return new ResponseStructure<>(200, "Post is fetched from DB succesfully", post, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Post>> fetchPostsByUsername(String username) {
		List<Post> list = postDao.findPostsByUsername(username);

		return new ResponseStructure<>(200, "Posts are fetched succesfully", list, LocalDateTime.now());
	}

}
