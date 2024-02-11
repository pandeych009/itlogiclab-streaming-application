package com.itlogiclab.microservice.streaming.consumer.dataaccess.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.mapper.StreamApplicationUtils;
import com.itlogiclab.microservice.streaming.consumer.dataaccess.entity.StreamEntity;

@Component
public class StreamDataAccessMapper {

	public List<Stream> mapStreamEntitiesToStreams(List<StreamEntity> streams){
		return streams.stream().map(entity -> mapStreamEntityToStream(entity)).collect(Collectors.toList());
	}


	public Stream mapStreamEntityToStream(StreamEntity streamEntity){
		return Stream
				.builder()
				.withId(streamEntity.getId())
				.withUserId(streamEntity.getUserId())
				.withData(streamEntity.getText())
				.withCreatedAt(streamEntity.getCreatedAt())
				.build();
	}


	public StreamEntity mapStreamToStreamEntity(Stream stream){
		return StreamEntity
				.builder()
				//.withId(stream.getId())
				.withUserId(stream.getUserId())
				.withText(stream.getData())
				.withCreatedAt(StreamApplicationUtils.CURRENT_DATE)
				.build();

	}

	public List<StreamEntity> mapStreamsToStreamEntities(List<Stream> streams){
		return streams.stream().map(stream -> mapStreamToStreamEntity(stream)).collect(Collectors.toList());
	}

}
