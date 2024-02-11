package com.itlogiclab.microservice.streaming.consumer.service.domain.ports.input.message.listener;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;

public interface StreamMessageKafkaListener {
	
	Stream recieve();

}
