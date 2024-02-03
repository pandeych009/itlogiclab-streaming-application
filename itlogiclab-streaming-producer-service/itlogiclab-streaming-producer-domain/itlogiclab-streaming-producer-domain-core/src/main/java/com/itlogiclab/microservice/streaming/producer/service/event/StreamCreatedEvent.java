package com.itlogiclab.microservice.streaming.producer.service.event;


import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.domain.event.StreamEvent;

public class StreamCreatedEvent extends StreamEvent {

	public StreamCreatedEvent(Stream stream) {
		super(stream);
	} 
	
}
