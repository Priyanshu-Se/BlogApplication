package com.jsp.demo.daoImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.demo.daoInterfaces.PostDao;
import com.jsp.demo.entity.Post;
import com.jsp.demo.exceptions.EntityNotFoundException;
import com.jsp.demo.repository.PostRepository;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private PostRepository repository;

	
	@Override
	public Post savePost(Post post) {
		return repository.save(post);

	}

	@Override
	public boolean deletePostById(int id) {
		Post post = findPostById(id);
		repository.delete(post);
		return true;
	}

	@Override
	public Post findPostById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Post with the id is not available"));
	}

	@Override
	public List<Post> findPostsByUsername(String username) {
		return repository.findPostsByUsername(username);
	}

}
