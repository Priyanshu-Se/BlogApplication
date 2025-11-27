package com.jsp.demo.daoInterfaces;

import com.jsp.demo.entity.User;

public interface UserDao {

	public User saveUser(User user);

	public User updateUser(User user);

	public User findUserByUserNameAndPassword(String username, String password);

	public User findUserByUserName(String username);

	public User findUserByEmail(String username);

	public User findUserByPhoneNumber(String username);

	public User findUserById(int id);

}
