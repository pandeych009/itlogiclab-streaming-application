package com.itlogiclab.microservice.streaming.service.domain.mapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;

@Component
public class StreamDomainMapper {

	private static final Logger LOG = LoggerFactory.getLogger(StreamDomainMapper.class);
	
	public Stream createStreamEntity(String stream) {
		long streamHashCode = stream.hashCode();
		LOG.info("StreamDomainMapper: Stream is about to build: userId: {}", streamHashCode);
		return Stream.builder()
				.withData(stream)
				.withId(streamHashCode)
				.withUserId(streamHashCode)
				.withCreatedAt(ZonedDateTime.now(ZoneId.of("UTC")))
				.build();
	}
}
