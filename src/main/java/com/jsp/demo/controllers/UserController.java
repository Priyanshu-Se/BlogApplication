package com.jsp.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.demo.converters.UserConverter;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.dto.SignInDto;
import com.jsp.demo.dto.UserDto;
import com.jsp.demo.entity.User;
import com.jsp.demo.serviceInterfaces.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("userconverter")
	private Converter<UserDto, User> converter;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody UserDto userdto) {
		User user = converter.convert(userdto);
		ResponseStructure<User> structure = userService.saveUser(user);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody UserDto user, @RequestParam("id") int id) {
		return null;
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> findByUsernameAndPassword(@RequestBody SignInDto dto) {
		ResponseStructure<User> structure = userService.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<ResponseStructure<User>> findByUsername(@PathVariable("username") String username) {
		ResponseStructure<User> structure = userService.findByUsername(username);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

}
