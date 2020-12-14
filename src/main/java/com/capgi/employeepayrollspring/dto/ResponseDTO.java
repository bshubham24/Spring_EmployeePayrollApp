package com.capgi.employeepayrollspring.dto;

import lombok.Data;

public @Data class ResponseDTO {
	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public ResponseDTO(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
	}
}
