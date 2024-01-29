package com.itlogiclab.microservice.streaming.producer.service.event;

import com.itlogiclab.microservice.streaming.producer.service.entity.Stream;

public class StreamCreatedEvent extends StreamEvent {

	public StreamCreatedEvent(Stream stream) {
		super(stream);
	} 
	
}
