package com.jsp.demo.serviceInterfaces;

import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Like;

public interface LikeService {

	ResponseStructure saveLike(Like like, String username, int postId);

	ResponseStructure delete(int postId, String username);

}
