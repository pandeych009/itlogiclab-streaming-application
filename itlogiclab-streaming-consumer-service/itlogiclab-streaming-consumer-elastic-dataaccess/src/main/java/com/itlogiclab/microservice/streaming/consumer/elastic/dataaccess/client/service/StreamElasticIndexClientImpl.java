package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

import com.itlogiclab.microservice.streaming.common.config.ElasticConfigData;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.utils.ElasticIndexUtil;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model.StreamIndexModel;

@Service
@ConditionalOnProperty(name = "is-repository", havingValue = "false" )
public class StreamElasticIndexClientImpl implements ElasticIndexClient<StreamIndexModel> {

	private static final Logger LOG = LogManager.getLogger(StreamElasticIndexClientImpl.class);
	
	
	private final ElasticConfigData   						elasticConfigData; 
	private final ElasticsearchOperations 					elasticsearchOperations;
	private final ElasticIndexUtil<StreamIndexModel>		elasticIndexUtil;
	
	public StreamElasticIndexClientImpl(ElasticConfigData elasticConfigData,
			ElasticsearchOperations elasticsearchOperations,
			ElasticIndexUtil<StreamIndexModel> elasticIndexUtil) {
		super();
		this.elasticConfigData 			= elasticConfigData;
		this.elasticsearchOperations 	= elasticsearchOperations;
		this.elasticIndexUtil 			= elasticIndexUtil;
	}

	@Override
	public List<String> save(List<StreamIndexModel> documents) {
		// TODO Auto-generated method stub
		List<IndexQuery> indexQueries 						= elasticIndexUtil.getIndexquery(documents);
		List<String> documentIds							= elasticsearchOperations.bulkIndex(
																	indexQueries, 
																	IndexCoordinates.of(elasticConfigData.getIndexName())
																	).stream().map(IndexedObjectInformation::id).collect(Collectors.toList()); 
		
		LOG.info("Document indexed successfully with type: {} and ids: ()", StreamIndexModel.class.getName(), documentIds);
		
		return documentIds;
	}

}
