package com.jsp.demo.dto;

import java.time.LocalDateTime;

import com.jsp.demo.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

	public ResponseStructure(int i, String string, Object object, LocalDateTime now) {
		// TODO Auto-generated constructor stub
	}
	private int statusCode;
	private String description;
	private T data;
	private LocalDateTime timeStamp;
	
	public Post getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
