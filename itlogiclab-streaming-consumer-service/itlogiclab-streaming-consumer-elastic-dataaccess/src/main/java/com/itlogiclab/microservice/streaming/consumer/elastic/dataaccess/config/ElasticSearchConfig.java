package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.itlogiclab.microservice.streaming.common.config.ElasticConfigData;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess")
public class ElasticSearchConfig extends ElasticsearchConfiguration{
	private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchConfig.class);
	
	private final ElasticConfigData elasticConfigData;

	public ElasticSearchConfig(ElasticConfigData elasticConfigData) {
		super();
		this.elasticConfigData = elasticConfigData;
	}
	
	@Override
	public ClientConfiguration clientConfiguration() {
		// TODO Auto-generated method stub
		LOG.debug("ElasticSearchConfig: About to create Client configuration");
		return ClientConfiguration.builder()
				.connectedTo(elasticConfigData.getConnectionUrl()) 
				.withConnectTimeout(elasticConfigData.getConnectTimeoutMs())
				.withSocketTimeout(elasticConfigData.getSocketTimeoutMs())
				.build();
	}
}
