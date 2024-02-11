package com.itlogiclab.microservice.streaming.consumer.service.domain.ports.output.respository;

import java.util.List;

import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;

public interface StreamRepository {

	public List<Stream> findStream();
	
	public Stream findStreamById(Long Id);
	
	public Stream save(Stream stream); 
	
	public List<Stream> saveAll(List<Stream> streams);
	
}
