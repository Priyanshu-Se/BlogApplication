package com.jsp.demo.serviceInterfaces;

import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.User;

public interface UserService {

	ResponseStructure<User> saveUser(User user);

	ResponseStructure<User> updateUser(User user);

	ResponseStructure<User> findByUsernameAndPassword(String username, String password);

	ResponseStructure<User> findByUsername(String username);

}
