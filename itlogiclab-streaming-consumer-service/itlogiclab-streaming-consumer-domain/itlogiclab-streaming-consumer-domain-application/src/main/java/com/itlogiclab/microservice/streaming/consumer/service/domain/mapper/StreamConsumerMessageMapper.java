package com.itlogiclab.microservice.streaming.consumer.service.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.mapper.StreamApplicationUtils;
import com.itlogiclab.microservice.streaming.kafka.avro.modal.StreamAvroModel;

@Component
public class StreamConsumerMessageMapper {

	public Stream mapStreamFromStreamAvroModel(StreamAvroModel avroModel) {
		return Stream
				.builder()
				.withData(avroModel.getText())
				.withId(avroModel.getId())
				.withUserId(avroModel.getUserId())
				.withCreatedAt(StreamApplicationUtils.CURRENT_DATE)
				.build();
	}
	
	
	public List<Stream> mapStreamFromStreamAvroModel(List<StreamAvroModel> avroModels) {
		return avroModels.stream().map(avroModel -> mapStreamFromStreamAvroModel(avroModel)).collect(Collectors.toList());
	}
}
