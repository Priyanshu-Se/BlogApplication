package com.jsp.demo.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.demo.daoInterfaces.UserDao;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.User;
import com.jsp.demo.serviceInterfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseStructure<User> saveUser(User user) {

		/*
		 * 
		 * 
		 * */

		User saveUser = userDao.saveUser(user);

		return new ResponseStructure<User>(200, "User registered successfully", saveUser, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<User> updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseStructure<User> findByUsernameAndPassword(String username, String password) {
		User user = userDao.findUserByUserNameAndPassword(username, password);
		return new ResponseStructure<>(200, "User is logged in", user, LocalDateTime.now());

	}

	@Override
	public ResponseStructure<User> findByUsername(String username) {
		User user = userDao.findUserByUserName(username);
		return new ResponseStructure<>(200, "User is fetched from the db", user, LocalDateTime.now());
	}

}
