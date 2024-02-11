package com.itlogiclab.microservice.streaming.consumer.service.domain;

import java.util.List;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;

public interface StreamRequestMessageDomainService {
	
	public List<String> persisteStream(List<Stream> stream); 

}
