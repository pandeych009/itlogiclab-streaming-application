package com.itlogiclab.microservice.streaming.consumer.service.domain.ports.output.elastic.repos;

import java.util.List;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;


public interface StreamMessageElasticServiceRepos {
	
	public List<String> save(List<Stream> documents);
}
