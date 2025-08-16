package com.javaGraphql.com.exception;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetails {

	
	private LocalTime localtime;
	private String message;
	private String details;
	private String errorMessage;



	public ErrorDetails(String details, String message,String errorMessage,LocalTime localtime) {
		super();
		this.localtime = localtime;
		this.message = message;
		this.details = details;
		this.errorMessage = errorMessage;
	}
	
}