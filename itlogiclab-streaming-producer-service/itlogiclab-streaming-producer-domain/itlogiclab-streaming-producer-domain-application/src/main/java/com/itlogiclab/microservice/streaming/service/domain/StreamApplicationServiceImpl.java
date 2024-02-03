package com.itlogiclab.microservice.streaming.service.domain;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.config.StreamServiceConfig;
import com.itlogiclab.microservice.streaming.common.domain.event.StreamEvent;
import com.itlogiclab.microservice.streaming.common.utils.StreamApplicationConstants;
import com.itlogiclab.microservice.streaming.producer.service.event.StreamCreatedEvent;
import com.itlogiclab.microservice.streaming.service.domain.mapper.StreamDomainMapper;
import com.itlogiclab.microservice.streaming.service.domain.ports.input.message.listener.StreamGenerationMessageListener;
import com.itlogiclab.microservice.streaming.service.domain.ports.input.service.StreamApplicationService;

@Component
public class StreamApplicationServiceImpl implements StreamApplicationService<String> {

	private static final Logger LOG = LoggerFactory.getLogger(StreamApplicationServiceImpl.class);
	private static final Random RANDOM = new Random();
	
	private final StreamServiceConfig 					streamServiceConfig;
	private final StreamGenerationMessageListener   	streamGenerationMessageListener; 
	private final StreamDomainMapper					streamDomainMapper;
	
	public StreamApplicationServiceImpl(StreamServiceConfig streamServiceConfig, 
			StreamDomainMapper streamDomainMapper, 
			StreamGenerationMessageListener streamGenerationMessageListener) {
		this.streamServiceConfig 					= streamServiceConfig;
		this.streamGenerationMessageListener 		= streamGenerationMessageListener;
		this.streamDomainMapper 					= streamDomainMapper;
	}

	@Override
	public String produceStream() {
		// TODO Auto-generated method stub
		LOG.info("StreamProducerImpl: Producing a stream from here: {}", streamServiceConfig);
		String[] streamKeywords = streamServiceConfig.getFilterKeywords().toArray(new String[0]); 
		int minStreamLength		= streamServiceConfig.getMinLength(); 
		int maxStreamLength		= streamServiceConfig.getMaxLength();
		Long streamSleepTime	= streamServiceConfig.getSleepMs();
		simulateTwitterStream(streamKeywords, minStreamLength, maxStreamLength, streamSleepTime);
		return null;
	}

	/**
	 * @param sleepTime
	 */
	private void sleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error while sleeping for waiting new status to create!");
		}
	}
	
	private void simulateTwitterStream(String[] streamKeywords, int minStreamLength, int maxStreamLength, long sleepTime) {
		Executors.newSingleThreadExecutor().submit(() -> {
			try {
				while(true) {
					String formattedStreamAsRawJson = getFomattedStream(streamKeywords, minStreamLength, maxStreamLength);
					StreamEvent domainEvent = new StreamCreatedEvent(streamDomainMapper.createStreamEntity(formattedStreamAsRawJson)); 
					LOG.info("StreamApplicationServiceImpl: Sleeping for {} ms", sleepTime);
					streamGenerationMessageListener.onApplicationEvent(domainEvent);
					sleep(sleepTime);
				}
			} catch (RuntimeException e) {  
				LOG.error("Error while creating stream!");
			}
		});
	}
	
	/**
	 * @param streamKeywords
	 * @param minStreamLength
	 * @param maxStreamLength
	 * @return
	 */
	private String getFomattedStream(String[] streamKeywords, int minStreamLength, int maxStreamLength) {
		// TODO Auto-generated method stub
		
		String[] params = new String[]{
			ZonedDateTime.now().format(DateTimeFormatter.ofPattern(StreamApplicationConstants.REQUEST_DATE_FORMAT, Locale.ENGLISH)), 
			String.valueOf(ThreadLocalRandom.current().nextLong()),
			getRandomStreamContent(streamKeywords, minStreamLength, maxStreamLength), 
			String.valueOf(ThreadLocalRandom.current().nextLong(Long.MAX_VALUE))
		};
		
		return formatStreamAsJsonWithParams(params);
	}
	
	
	/**
	 * @param params
	 * @return
	 */
	private String formatStreamAsJsonWithParams(String[] params) {
		String streamText = StreamApplicationConstants.REQUEST_AS_RAW_JSON; 
		for(int index=0; index < params.length; index++) {
			streamText = streamText.replace("{"+index+"}", params[index]);
		}
		
		return streamText;
	}
	/**
	 * @param streamKeywords
	 * @param minStreamLength
	 * @param maxStreamLength
	 * @return
	 */
	private String getRandomStreamContent(String[] streamKeywords, int minStreamLength, int maxStreamLength) {
		// TODO Auto-generated method stub
		StringBuilder streamBuilder = new StringBuilder(); 
		int streamLength = RANDOM.nextInt(maxStreamLength - minStreamLength + 1) + minStreamLength;
		return constructRandomStream(streamKeywords, streamBuilder, streamLength);
	}
	
	
	/**
	 * @param streamKeywords
	 * @param streamBuilder
	 * @param streamLength
	 * @return
	 */
	private String constructRandomStream(String[] streamKeywords, StringBuilder streamBuilder, int streamLength) {
		// TODO Auto-generated method stub
		for(int index = 0; index < streamLength; index++) {
			streamBuilder
			.append(StreamApplicationConstants.STREAM[RANDOM.nextInt(StreamApplicationConstants.STREAM.length)])
			.append(" "); 
			if(index % 2 == 0) {
				streamBuilder
				.append(streamKeywords[RANDOM.nextInt(streamKeywords.length)])
				.append(" "); 
			}
		}
		return streamBuilder.toString();
	}

}
