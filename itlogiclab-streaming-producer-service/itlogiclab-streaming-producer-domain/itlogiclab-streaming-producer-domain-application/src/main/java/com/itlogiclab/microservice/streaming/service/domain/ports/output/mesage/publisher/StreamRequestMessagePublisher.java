package com.itlogiclab.microservice.streaming.service.domain.ports.output.mesage.publisher;

import java.util.function.BiConsumer;

import com.itlogiclab.microservice.common.domain.valueobject.StreamStatus;
import com.itlogiclab.microservice.streaming.producer.service.entity.Stream;

public interface StreamRequestMessagePublisher {
	void publish(Stream stream, BiConsumer<Stream, StreamStatus> streamCallBack);
	
	void publish(Stream stream);
}
