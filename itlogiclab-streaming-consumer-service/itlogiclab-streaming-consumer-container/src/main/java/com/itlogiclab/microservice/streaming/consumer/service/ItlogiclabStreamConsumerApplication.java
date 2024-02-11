package com.itlogiclab.microservice.streaming.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.itlogiclab.microservice.common.kafka.config.data.KafkaConfigData;
import com.itlogiclab.microservice.common.kafka.config.data.KafkaConsumerConfigData;
import com.itlogiclab.microservice.streaming.common.config.StreamServiceConfig;
import com.itlogiclab.microservice.streaming.consumer.service.domain.StreamRequestMessageDomainService;

@SpringBootApplication(scanBasePackages = "com.itlogiclab.microservice")
@EnableJpaRepositories(basePackages = {
		"com.itlogiclab.microservice.streaming.consumer.dataaccess" 
		})
@EntityScan(basePackages = {
		"com.itlogiclab.microservice.streaming.consumer.dataaccess"
		})
public class ItlogiclabStreamConsumerApplication implements CommandLineRunner{
	
	private static final Logger LOG = LoggerFactory.getLogger(ItlogiclabStreamConsumerApplication.class);
	
	private final StreamServiceConfig  		streamServiceConfig;
	private final KafkaConfigData 			kafkaConfigData;
	private final KafkaConsumerConfigData   kafkaConsumerConfigData;
	
	public ItlogiclabStreamConsumerApplication(StreamServiceConfig streamServiceConfig,
			KafkaConfigData kafkaConfigData, 
			KafkaConsumerConfigData kafkaConsumerConfigData) {
		super();
		this.streamServiceConfig = streamServiceConfig;
		this.kafkaConfigData = kafkaConfigData;
		this.kafkaConsumerConfigData = kafkaConsumerConfigData;
	}



	public static void main(String[] args) {
		LOG.debug("ItlogiclabStreamConsumerApplication: Application is about to start");
		SpringApplication.run(ItlogiclabStreamConsumerApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("ItlogiclabStreamConsumerApplication: PRINTING CONFIG DATA AT START ");
		LOG.info("ItlogiclabStreamConsumerApplication: "+streamServiceConfig);
		LOG.info("ItlogiclabStreamConsumerApplication: "+kafkaConfigData);
		LOG.info("ItlogiclabStreamConsumerApplication: "+kafkaConsumerConfigData);
		
		//streamRequestMessageDomainService.persisteStream(null);
		
	}

	

}
