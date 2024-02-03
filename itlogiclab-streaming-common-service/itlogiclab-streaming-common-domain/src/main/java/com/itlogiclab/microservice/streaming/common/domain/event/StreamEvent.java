package com.itlogiclab.microservice.streaming.producer.service.event;

import com.itlogiclab.microservice.common.domain.event.DomainEvent;
import com.itlogiclab.microservice.streaming.producer.service.entity.Stream;

public abstract class StreamEvent implements DomainEvent<Stream>{
	
	private final Stream stream;

	public StreamEvent(Stream stream) {
		super();
		this.stream = stream;
	}

	/**
	 * @return the stream
	 */
	public Stream getStream() {
		return stream;
	}

	@Override
	public String toString() {
		return "StreamEvent [stream=" + stream + "]";
	} 
	
}
