package com.itlogiclab.microservice.streaming.service.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.service.domain.dto.create.CreateStreamRequest;

@Component
public class StreamGenerationMessagePublisher {

	private static final Logger LOG = LoggerFactory.getLogger(StreamGenerationMessagePublisher.class); 
	
	private final ApplicationEventPublisher applicationEventPublisher;

	public StreamGenerationMessagePublisher(ApplicationEventPublisher applicationEventPublisher) {
		super();
		this.applicationEventPublisher = applicationEventPublisher;
	}  
	
	
	public void publishStreamGenerationEvent(final CreateStreamRequest createStreamRequest) {
		// TODO Auto-generated method stub
		LOG.info("StreamGenerationMessagePublisher: Publishing event: {}",createStreamRequest.getStreamRequest() );
		applicationEventPublisher.publishEvent(createStreamRequest);
	}
	
	
}
