package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model.StreamIndexModel;

@Service
@ConditionalOnProperty(name = "is-repository", havingValue = "true", matchIfMissing = true )
public class ElasticRepositoryIndexClientImpl implements ElasticIndexClient<StreamIndexModel> {

	private static final Logger LOG = LogManager.getLogger(ElasticRepositoryIndexClientImpl.class);

//	private final StreamElasticSearchIndexRepos streamElasticSearchIndexRepos;
//
//	public ElasticRepositoryIndexClientImpl(StreamElasticSearchIndexRepos streamElasticSearchIndexRepos) {
//		this.streamElasticSearchIndexRepos = streamElasticSearchIndexRepos;
//	}

	@Override
	public List<String> save(List<StreamIndexModel> documents) {
		// TODO Auto-generated method stub
		//List<StreamIndexModel> repositoryResponse = (List<StreamIndexModel>) streamElasticSearchIndexRepos.saveAll(documents);
		//List<String> ids = repositoryResponse.stream().map(StreamIndexModel::getId).collect(Collectors.toList());
		//LOG.info("Document indexed successfully with type: {} and ids: ()", StreamIndexModel.class.getName(), ids);

		return null;
	}

}
