package com.itlogiclab.microservice.streaming.service.domain.ports.input.message.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class StreamListener implements ApplicationListener<ApplicationEvent> {
	private static final Logger LOG = LogManager.getLogger(StreamListener.class); 
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
	}//https://www.baeldung.com/spring-eventsaa

}
