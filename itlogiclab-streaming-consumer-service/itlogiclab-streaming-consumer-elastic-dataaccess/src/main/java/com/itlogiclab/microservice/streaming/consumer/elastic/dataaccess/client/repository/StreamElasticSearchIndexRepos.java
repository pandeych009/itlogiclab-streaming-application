package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model.StreamIndexModel;

@Repository
public interface StreamElasticSearchIndexRepos extends ElasticsearchRepository<StreamIndexModel, String>{

}
