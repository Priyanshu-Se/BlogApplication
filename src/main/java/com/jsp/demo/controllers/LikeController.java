package com.jsp.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.demo.dto.LikeDto;
import com.jsp.demo.dto.ResponseStructure;
import com.jsp.demo.entity.Like;
import com.jsp.demo.serviceInterfaces.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeService service;

	@PostMapping
	@CrossOrigin
	public ResponseEntity<ResponseStructure> saveLike(@RequestBody LikeDto dto) {
		ResponseStructure structure = service.saveLike(new Like(), dto.getUsername(), dto.getPostId());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure> deleteLike(@RequestBody LikeDto dto) {
		ResponseStructure structure = service.delete(dto.getPostId(), dto.getUsername());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.OK);
	}
}
