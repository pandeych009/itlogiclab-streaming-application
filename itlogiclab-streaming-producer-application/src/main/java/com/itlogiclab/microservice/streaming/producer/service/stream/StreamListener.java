package com.itlogiclab.microservice.streaming.producer.service.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class StreamListener implements ApplicationListener<ApplicationEvent>{
	private static final Logger LOG = LoggerFactory.getLogger(StreamListener.class);
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		LOG.info("StreamListener: Listener started listen");
		
	}

}
