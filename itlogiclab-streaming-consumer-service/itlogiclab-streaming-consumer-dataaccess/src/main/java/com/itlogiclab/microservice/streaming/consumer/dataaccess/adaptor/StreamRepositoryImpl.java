package com.itlogiclab.microservice.streaming.consumer.dataaccess.adaptor;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.consumer.dataaccess.entity.StreamEntity;
import com.itlogiclab.microservice.streaming.consumer.dataaccess.mapper.StreamDataAccessMapper;
import com.itlogiclab.microservice.streaming.consumer.dataaccess.repository.StreamJPARepository;
import com.itlogiclab.microservice.streaming.consumer.service.domain.ports.output.respository.StreamRepository;

@Service
public class StreamRepositoryImpl implements StreamRepository{

	public static final Logger LOG = LoggerFactory.getLogger(StreamRepositoryImpl.class);
	
	
	private final StreamJPARepository 		streamJPARepos; 
	private final StreamDataAccessMapper    streamDataAccessMapper; 
	
	public StreamRepositoryImpl(StreamJPARepository streamJPARepos, StreamDataAccessMapper streamDataAccessMapper) {
		super();
		this.streamJPARepos = streamJPARepos;
		this.streamDataAccessMapper = streamDataAccessMapper;
	}

	@Override
	public List<Stream> findStream() {
		// TODO Auto-generated method stub
		List<StreamEntity> streamEntities = streamJPARepos.findAll();
		List<Stream> streams =  streamDataAccessMapper.mapStreamEntitiesToStreams(streamEntities);
		return streams;
	}

	@Override
	public Stream findStreamById(Long Id) {
		// TODO Auto-generated method stub
		Optional<StreamEntity> streamEntityOptional = streamJPARepos.findById(Id);
		if(streamEntityOptional.isPresent())
			return streamDataAccessMapper.mapStreamEntityToStream(streamEntityOptional.get());
		return null;
	}

	@Override
	public Stream save(Stream stream) {
		// TODO Auto-generated method stub
		StreamEntity streamToBePersisted = streamDataAccessMapper.mapStreamToStreamEntity(stream);
		StreamEntity streamPersisted = streamJPARepos.save(streamToBePersisted);
		return streamDataAccessMapper.mapStreamEntityToStream(streamPersisted);
	}

	@Override
	public List<Stream> saveAll(List<Stream> streams) {
		// TODO Auto-generated method stub
		List<StreamEntity> entitiesToBePersisted = streamDataAccessMapper.mapStreamsToStreamEntities(streams);
		List<StreamEntity> persistedEntities = streamJPARepos.saveAll(entitiesToBePersisted);
		
		return streamDataAccessMapper.mapStreamEntitiesToStreams(persistedEntities);
	}

	
	
}
