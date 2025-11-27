package com.jsp.demo.daoInterfaces;

import com.jsp.demo.entity.Like;

public interface LikeDao {

	public boolean saveLike(Like like);

	public boolean deleteLike(int postId, String username);
	
}
