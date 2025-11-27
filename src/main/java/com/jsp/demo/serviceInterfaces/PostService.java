package com.jsp.demo.serviceInterfaces;

import java.util.List;

import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Post;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface PostService {

	ResponseStructure<Post> savePost(Post post,String username);

	ResponseStructure<Post> deletePostById(int id);

	ResponseStructure<Post> fetchPostById(int id);

	ResponseStructure<List<Post>> fetchPostsByUsername(String username);
}
