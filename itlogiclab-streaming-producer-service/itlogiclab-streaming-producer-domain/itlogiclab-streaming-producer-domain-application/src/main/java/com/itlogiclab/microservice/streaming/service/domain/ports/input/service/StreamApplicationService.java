package com.itlogiclab.microservice.streaming.service.domain.ports.input.service;

public interface StreamApplicationService<T> {
	
	public T produceStream();
	
}
