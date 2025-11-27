package com.jsp.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jsp.demo.dto.PostDto;
import com.jsp.demo.entity.Post;


@Component
public class PostConverter implements Converter<PostDto, Post> {

	@Override
	public Post convert(PostDto source) {
		return new Post(0, source.getTitle(), source.getDescription(), null, null, null, null);
	}

}