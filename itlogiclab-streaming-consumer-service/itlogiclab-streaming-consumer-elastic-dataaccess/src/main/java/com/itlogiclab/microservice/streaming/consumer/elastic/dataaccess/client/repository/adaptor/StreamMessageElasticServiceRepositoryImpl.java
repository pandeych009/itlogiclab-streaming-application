package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.repository.adaptor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.service.ElasticIndexClient;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.mapper.StreamIndexModelTransformer;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model.StreamIndexModel;
import com.itlogiclab.microservice.streaming.consumer.service.domain.ports.output.elastic.repos.StreamMessageElasticServiceRepos;
@Component
public class StreamMessageElasticServiceRepositoryImpl implements StreamMessageElasticServiceRepos{

	private static final Logger LOG = LoggerFactory.getLogger(StreamMessageElasticServiceRepositoryImpl.class);

	private final ElasticIndexClient<StreamIndexModel>  elasticIndexClient;
	private final StreamIndexModelTransformer  			streamIndexModelTransformer;
	
	public StreamMessageElasticServiceRepositoryImpl(ElasticIndexClient<StreamIndexModel> elasticIndexClient, 
			StreamIndexModelTransformer streamIndexModelTransformer) {
		super();
		this.elasticIndexClient = elasticIndexClient;
		this.streamIndexModelTransformer = streamIndexModelTransformer;
	}
	

	@Override
	public List<String> save(List<Stream> documents) {
		// TODO Auto-generated method stub
		LOG.info("StreamMessageElasticServiceRepositoryImpl: Streams are about to save");
		List<StreamIndexModel> indexModels = streamIndexModelTransformer.mapStreamIndexModelFromStream(documents);
		return elasticIndexClient.save(indexModels);
	}	
}
