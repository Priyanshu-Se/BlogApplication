package com.jsp.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo.converters.PostConverter;
import com.jsp.demo.dto.IdDto;
import com.jsp.demo.dto.PostDto;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Post;
import com.jsp.demo.serviceInterfaces.PostService;


@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private PostConverter converter;

	@PostMapping
	public ResponseEntity<ResponseStructure<Post>> savePost(@RequestBody PostDto postDto) {
		Post post = converter.convert(postDto);
		ResponseStructure<Post> structure = postService.savePost(post,postDto.getUsername());
		return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Post>> deletePostById(@RequestBody IdDto dto) {
		ResponseStructure<Post> structure = postService.deletePostById(dto.getId());
		return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Post>> fetchPostById(@RequestParam("id") int id) {
		ResponseStructure<Post> structure = postService.fetchPostById(id);
		return new ResponseEntity<ResponseStructure<Post>>(structure, HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<ResponseStructure<List<Post>>> fetchPostsByUsername(
			@PathVariable("username") String username) {
		ResponseStructure<List<Post>> structure = postService.fetchPostsByUsername(username);
		return new ResponseEntity<ResponseStructure<List<Post>>>(structure, HttpStatus.OK);
	}

}