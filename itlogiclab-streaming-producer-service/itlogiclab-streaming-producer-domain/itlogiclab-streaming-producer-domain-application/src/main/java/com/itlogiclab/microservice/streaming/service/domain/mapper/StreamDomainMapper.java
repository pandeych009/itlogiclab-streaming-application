package com.itlogiclab.microservice.streaming.service.domain.mapper;

import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.producer.service.entity.StreamEntity;
import com.itlogiclab.microservice.streaming.service.domain.dto.create.CreateStreamRequest;

@Component
public class StreamDomainMapper {

	private static final Logger LOG = LoggerFactory.getLogger(StreamDomainMapper.class);
	private static long previousTimeMillis = System.currentTimeMillis();
	private static long counter = 0L;
	
	public StreamEntity createStreamEntity(String stream) {
		return StreamEntity.builder()
				.withData(stream)
				.withId(id())
				.withUserId(id())
				.withCreatedAt(ZonedDateTime.now())
				.build();
	}
	
	public CreateStreamRequest createStreamRequest(StreamEntity streamEntity) {
		return CreateStreamRequest.builder()
				.withStreamRequest(streamEntity)
				.build();
	}
	
	
	public static synchronized long id() {
	    long currentTimeMillis = System.currentTimeMillis();
	    counter = (currentTimeMillis == previousTimeMillis) ? (counter + 1L) & 1048575L : 0L;
	    previousTimeMillis = currentTimeMillis;
	    long timeComponent = (currentTimeMillis & 8796093022207L) << 20;
	    
	    Long id = timeComponent | counter;
	    LOG.info("StreamDomainMapper: Id generation request: {}", id);
	    return id;
	}
	
}
