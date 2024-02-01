package com.itlogiclab.microservice.streaming.producer.message.mapper;

import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.kafka.avro.modal.StreamAvroModel;
import com.itlogiclab.microservice.streaming.producer.service.entity.Stream;

@Component
public class StreamAvroTransformer {
	
	public StreamAvroModel buildStreamAvroModel(Stream stream) {
		return StreamAvroModel.newBuilder()
				.setId(stream.getId())
				.setUserId(stream.getUserId())
				.setText(stream.getData())
				.setCreatedAt(stream.getCreatedAt().toEpochSecond())
				.build();
	}
	

}
