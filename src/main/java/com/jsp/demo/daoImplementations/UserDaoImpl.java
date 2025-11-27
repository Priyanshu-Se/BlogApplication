package com.jsp.demo.daoImplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.demo.daoInterfaces.UserDao;
import com.jsp.demo.entity.User;
import com.jsp.demo.exceptions.EntityAlreadyExistsException;
import com.jsp.demo.exceptions.EntityNotFoundException;
import com.jsp.demo.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {

		boolean existsByEmail = repository.existsByEmail(user.getEmail());
		boolean existsByPhoneNumber = repository.existsByPhoneNumber(user.getPhoneNumber());
		boolean existsByUsername = repository.existsByUsername(user.getUsername());

//		String propertyName = "";
//		if (existsByEmail) {
//			propertyName = "email";
//		} else if (existsByPhoneNumber) {
//			propertyName = "phoneNumber";
//		} else if (existsByUsername) {
//			propertyName = "username";
//		}

		String propertyName = existsByEmail ? "email"
				: existsByPhoneNumber ? "phoneNumber" : existsByUsername ? "username" : "";

		if (!propertyName.equals("")) {
			String exceptionmsg = "User with " + propertyName + " is already presnt";
			throw new EntityAlreadyExistsException(exceptionmsg);
		}

		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUserNameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password)
				.orElseThrow(() -> new EntityNotFoundException("User with ithe credentils are not present"));
	}

	@Override
	public User findUserByUserName(String username) {
		return repository.findByUsername(username)
				.orElseThrow(() -> new EntityNotFoundException("User with the username is not present"));
	}

	@Override
	public User findUserById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User with the id is not present"));
	}

	@Override
	public User findUserByEmail(String email) {
		return repository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException("User with the email is not present"));
	}

	@Override
	public User findUserByPhoneNumber(String phoneNumber) {
		return repository.findByPhoneNumber(phoneNumber)
				.orElseThrow(() -> new EntityNotFoundException("User with the phonenumber is not present"));
	}

}
