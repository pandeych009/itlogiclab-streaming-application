package com.itlogiclab.microservice.streaming.service.domain.dto.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.common.domain.event.DomainEvent;
import com.itlogiclab.microservice.streaming.service.domain.dto.create.CreateStreamRequest;

@Component
public class StreamCreatedEvent extends ApplicationEvent implements DomainEvent<CreateStreamRequest> {
	
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(StreamCreatedEvent.class); 
	
	private final CreateStreamRequest createStreamRequest;

	public StreamCreatedEvent(Object source, CreateStreamRequest createStreamRequest) {
		super(source);
		this.createStreamRequest = createStreamRequest;
	} 
	
	public CreateStreamRequest createStreamRequest() {
		LOG.info("StreamCreatedEvent: Event : {}", createStreamRequest.getStreamRequest());
		return createStreamRequest;
	}
	
}
