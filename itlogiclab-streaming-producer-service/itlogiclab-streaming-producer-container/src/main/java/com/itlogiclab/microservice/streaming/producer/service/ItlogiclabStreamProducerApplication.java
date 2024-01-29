package com.itlogiclab.microservice.streaming.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itlogiclab.microservice.common.application.config.StreamServiceConfig;
import com.itlogiclab.microservice.streaming.service.domain.dto.create.CreateStreamRequest;
import com.itlogiclab.microservice.streaming.service.domain.ports.input.service.StreamApplicationService;

@SpringBootApplication(scanBasePackages = "com.itlogiclab.microservice")
public class ItlogiclabStreamProducerApplication implements CommandLineRunner{
	private static final Logger LOG = LoggerFactory.getLogger(ItlogiclabStreamProducerApplication.class);
	
	
	private final StreamServiceConfig  							 streamServiceConfig;
	private final StreamApplicationService<CreateStreamRequest>  streamApplicationService; 
	
	
	public ItlogiclabStreamProducerApplication(StreamServiceConfig streamServiceConfig, StreamApplicationService<CreateStreamRequest> streamApplicationService) {
		super();
		this.streamServiceConfig 		= streamServiceConfig;
		this.streamApplicationService 	= streamApplicationService;
	}



	public static void main(String[] args) {
		LOG.info("ItlogiclabStreamProducerApplication: Application is about to start");
		SpringApplication.run(ItlogiclabStreamProducerApplication.class, args);	
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("StreamServiceConfig: "+streamServiceConfig);
		streamApplicationService.produceStream();
		
	}
	
}
