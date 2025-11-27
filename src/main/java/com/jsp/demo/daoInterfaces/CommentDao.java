package com.jsp.demo.daoInterfaces;

import com.jsp.demo.entity.Comment;
import com.jsp.demo.entity.Like;

public interface CommentDao {
	
	public boolean saveComment(Comment comment);

	public boolean deletComment(int postId, int userId);

}
