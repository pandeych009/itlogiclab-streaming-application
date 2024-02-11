package com.itlogiclab.microservice.streaming.consumer.service.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;

@Component
public class StreamRequestMessageDomainServiceImpl implements StreamRequestMessageDomainService {

	private static final Logger LOG = LoggerFactory.getLogger(StreamRequestMessageDomainServiceImpl.class); 
	
	
	@Override
	public List<String> persisteStream(List<Stream>  documents) {
		// TODO Auto-generated method stub
		LOG.info("StreamRequestMessageListenerImpl: Document is about to save:");
		while(true) {
			LOG.info("StreamRequestMessageListenerImpl: Running on infinite loop:");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

