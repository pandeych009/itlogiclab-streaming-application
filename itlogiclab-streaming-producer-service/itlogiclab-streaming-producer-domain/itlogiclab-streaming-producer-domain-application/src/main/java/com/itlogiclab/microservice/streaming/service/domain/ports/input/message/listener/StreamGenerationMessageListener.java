package com.itlogiclab.microservice.streaming.service.domain.ports.input.message.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.producer.service.event.StreamEvent;
import com.itlogiclab.microservice.streaming.service.domain.ports.output.mesage.publisher.StreamRequestMessagePublisher;

@Component
public class StreamGenerationMessageListener  {

	private static final Logger LOG = LoggerFactory.getLogger(StreamGenerationMessageListener.class);
	
	private StreamRequestMessagePublisher streamRequestMessagePublisher;

	public StreamGenerationMessageListener(StreamRequestMessagePublisher streamRequestMessagePublisher) {
		super();
		this.streamRequestMessagePublisher = streamRequestMessagePublisher;
	}


	@EventListener
	public <T> void onApplicationEvent(StreamEvent event) {
		// TODO Auto-generated method stub
		LOG.info("StreamGenerationMessageListener: Publishing event: {}", event);
		streamRequestMessagePublisher.publish(event.getStream());
	} 
}
