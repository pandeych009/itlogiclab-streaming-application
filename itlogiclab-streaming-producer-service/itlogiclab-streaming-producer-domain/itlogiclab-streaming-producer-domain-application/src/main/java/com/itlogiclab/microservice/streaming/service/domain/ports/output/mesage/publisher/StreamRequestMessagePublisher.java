package com.itlogiclab.microservice.streaming.service.domain.ports.output.mesage.publisher;

import java.util.function.BiConsumer;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.domain.valueobject.StreamStatus;

public interface StreamRequestMessagePublisher {
	void publish(Stream stream, BiConsumer<Stream, StreamStatus> streamCallBack);
	
	void publish(Stream stream);
}
