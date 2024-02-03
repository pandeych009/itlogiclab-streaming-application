package com.itlogiclab.microservice.streaming.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItlogiclabStreamConsumerApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(ItlogiclabStreamConsumerApplication.class);
	
	public static void main(String[] args) {
		LOG.debug("ItlogiclabStreamConsumerApplication: Application is about to start");
		SpringApplication.run(ItlogiclabStreamConsumerApplication.class, args);
	}

}
