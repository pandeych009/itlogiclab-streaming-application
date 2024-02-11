package com.itlogiclab.microservice.streaming.consumer.service.event;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.domain.event.StreamEvent;

public class StreamConsumeEvent extends StreamEvent {

	public StreamConsumeEvent(Stream stream) {
		super(stream);
	}

}
