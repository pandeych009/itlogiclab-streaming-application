package com.itlogiclab.microservice.streaming.common.domain.exception;

public class StreamDomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public StreamDomainException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StreamDomainException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
