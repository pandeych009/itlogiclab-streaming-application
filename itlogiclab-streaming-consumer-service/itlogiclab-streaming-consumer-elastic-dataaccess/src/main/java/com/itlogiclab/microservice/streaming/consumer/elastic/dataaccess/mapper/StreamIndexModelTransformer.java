package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.mapper.StreamApplicationUtils;
import com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model.StreamIndexModel;
import com.itlogiclab.microservice.streaming.kafka.avro.modal.StreamAvroModel;

@Component
public class StreamIndexModelTransformer {

	public StreamIndexModel streamAvroModelToElasticIndexTransformer(StreamAvroModel streamAvroModel) {
		// TODO Auto-generated method stub
		return StreamIndexModel
				.builder()
				.withId(String.valueOf(streamAvroModel.getId()))
				.withText(streamAvroModel.getText())
				.withUserId(streamAvroModel.getUserId())
				.withCreatedAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(streamAvroModel.getCreatedAt()),  ZoneId.systemDefault()))
				.build();

	}
	
	
	public List<StreamIndexModel> streamAvroModelToElasticIndexTransformer(List<StreamAvroModel> streamAvroModels){
		return streamAvroModels.stream().map(streamAvroModel -> streamAvroModelToElasticIndexTransformer(streamAvroModel)).collect(Collectors.toList());
	}
	
	
	public StreamIndexModel mapStreamIndexModelFromStream(Stream stream) {
		return StreamIndexModel
				.builder()
				.withId(String.valueOf(stream.getId()))
				.withUserId(stream.getUserId())
				.withText(stream.getData())
				.withCreatedAt(StreamApplicationUtils.CURRENT_DATE.toLocalDateTime())// This need to be checked. 
				.build();
	}
	
	public List<StreamIndexModel> mapStreamIndexModelFromStream(List<Stream> streams) {
		return streams.stream().map(stream -> mapStreamIndexModelFromStream(stream)).collect(Collectors.toList());
	}
}
