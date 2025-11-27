package com.jsp.demo.daoImplementations;

import org.springframework.stereotype.Repository;

import com.jsp.demo.daoInterfaces.CommentDao;
import com.jsp.demo.entity.Comment;


@Repository
public class CommentDaoImpl implements CommentDao {

	@Override
	public boolean saveComment(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletComment(int postId, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
