package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.service;

import java.util.List;

import com.itlogiclab.microservice.streaming.common.elastic.modal.IndexModel;

public interface ElasticIndexClient<T extends IndexModel> {
	
	List<String> save(List<T> documents);
}
