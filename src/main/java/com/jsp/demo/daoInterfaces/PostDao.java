package com.jsp.demo.daoInterfaces;

import java.util.List;

import com.jsp.demo.entity.Post;

public interface PostDao {

	public Post savePost(Post post);

	public boolean deletePostById(int id);

	public Post findPostById(int id);

	public List<Post> findPostsByUsername(String username);

}
