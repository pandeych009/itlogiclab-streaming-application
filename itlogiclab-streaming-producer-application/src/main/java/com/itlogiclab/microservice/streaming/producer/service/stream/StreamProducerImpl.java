package com.itlogiclab.microservice.streaming.producer.service.stream;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.service.config.StreamServiceConfig;

@Component
public class StreamProducerImpl implements StreamProducer {
	private static final Logger LOG = LoggerFactory.getLogger(StreamProducerImpl.class);
	
	private final StreamServiceConfig streamServiceConfig;
	
	public StreamProducerImpl(StreamServiceConfig streamServiceConfig) {
		super();
		this.streamServiceConfig = streamServiceConfig;
	}

	@Override
	public void produce() {
		// TODO Auto-generated method stub
		Executors.newSingleThreadExecutor().submit(() -> {
			try {
				while(true) {
					LOG.info("StreamProducerImpl: Producing a stream from here: {}", streamServiceConfig);
					sleep(10000);
				}
			} catch (Exception e) {
				LOG.error("Error while creating status!");
			}
		});
	}

	private void sleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error while sleeping for waiting new status to create!");
		}

	}

}
