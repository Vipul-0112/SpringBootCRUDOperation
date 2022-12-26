package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiResponse {

	private String message;
	private String status;

	public ApiResponse() {
		super();
	}

	public ApiResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
