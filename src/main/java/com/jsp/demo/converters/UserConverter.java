package com.jsp.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jsp.demo.dto.UserDto;
import com.jsp.demo.entity.User;

@Component("userconverter")
public class UserConverter implements Converter<UserDto, User> {

	@Override
	public User convert(UserDto source) {

		if (source == null)
			return null;

		User user = new User();
		user.setName(source.getName());
		user.setUsername(source.getUsername());
		user.setPassword(source.getPassword());
		user.setEmail(source.getEmail());
		user.setPhoneNumber(source.getPhoneNumber());

		return user;
	}

}
