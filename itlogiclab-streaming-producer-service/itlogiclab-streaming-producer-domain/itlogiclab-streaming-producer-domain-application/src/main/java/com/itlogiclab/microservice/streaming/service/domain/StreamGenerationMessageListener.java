package com.itlogiclab.microservice.streaming.service.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.service.domain.dto.event.StreamCreatedEvent;

@Component
public class StreamGenerationMessageListener implements ApplicationListener<StreamCreatedEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(StreamGenerationMessageListener.class);

	@Override
	public void onApplicationEvent(StreamCreatedEvent event) {
		// TODO Auto-generated method stub
		LOG.info("StreamGenerationMessageListener: Consuming event: {}", event.createStreamRequest());
	} 
	
}
