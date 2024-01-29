package com.itlogiclab.microservice.streaming.service.domain.ports.input.message.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.common.domain.event.DomainEvent;
@Component
public class StreamGenerationMessageListener  {

	private static final Logger LOG = LoggerFactory.getLogger(StreamGenerationMessageListener.class);

	@EventListener
	public <T> void onApplicationEvent(DomainEvent<T> event) {
		// TODO Auto-generated method stub
		LOG.info("StreamGenerationMessageListener: Consuming event: {}", event);
	} 
}
