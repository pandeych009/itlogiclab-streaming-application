package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.client.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import com.itlogiclab.microservice.streaming.common.elastic.modal.IndexModel;

public class ElasticIndexUtil<T extends IndexModel> {

	public List<IndexQuery> getIndexquery(List<T> documentList) {
		return documentList.stream().map(document -> new IndexQueryBuilder()
				.withId(document.getId())
				.withObject(document)
				.build()
				).collect(Collectors.toList());
	}
}
