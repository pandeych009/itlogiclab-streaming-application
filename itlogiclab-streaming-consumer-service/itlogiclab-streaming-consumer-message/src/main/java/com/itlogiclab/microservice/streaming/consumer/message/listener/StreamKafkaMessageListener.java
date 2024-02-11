package com.itlogiclab.microservice.streaming.consumer.message.listener;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.common.kafka.config.data.KafkaConfigData;
import com.itlogiclab.microservice.common.kafka.config.data.KafkaConsumerConfigData;
import com.itlogiclab.microservice.common.kafka.consumer.KafkaConsumer;
import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.consumer.service.domain.mapper.StreamConsumerMessageMapper;
import com.itlogiclab.microservice.streaming.consumer.service.domain.ports.output.respository.StreamRepository;
import com.itlogiclab.microservice.streaming.kafka.avro.modal.StreamAvroModel;

@Component
public class StreamKafkaMessageListener implements KafkaConsumer<String, StreamAvroModel>{
	
	private static final Logger LOG = LoggerFactory.getLogger(StreamKafkaMessageListener.class);

//	private final StreamMessageElasticServiceRepos  streamMessageElasticServiceRepos; 
	private final StreamConsumerMessageMapper		streamConsumerMessageMapper;
	private final StreamRepository					streamRepository;
	private final KafkaListenerEndpointRegistry 	kafkaListenerEndpointRegistry;
	private final KafkaConfigData 					kafkaConfigData;
	private final KafkaConsumerConfigData   		kafkaConsumerConfigData;
	
	public StreamKafkaMessageListener(
			StreamConsumerMessageMapper streamConsumerMessageMapper, 
			//StreamMessageElasticServiceRepos streamMessageElasticServiceRepos,
			StreamRepository streamRepository, 
			KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry, 
			KafkaConfigData kafkaConfigData, 
			KafkaConsumerConfigData kafkaConsumerConfigData) {
		super();
//		this.streamMessageElasticServiceRepos 	= streamMessageElasticServiceRepos;
		this.streamConsumerMessageMapper 		= streamConsumerMessageMapper;
		this.streamRepository 					= streamRepository;
		this.kafkaListenerEndpointRegistry 		= kafkaListenerEndpointRegistry;
		this.kafkaConfigData 					= kafkaConfigData;
		this.kafkaConsumerConfigData = kafkaConsumerConfigData;
	}

	@EventListener
	public void onAppStarted(ApplicationStartedEvent event) {
		LOG.info("Topics with name {} is ready for operations!", kafkaConfigData.getTopicName());
        Objects.requireNonNull(kafkaListenerEndpointRegistry.getListenerContainer(kafkaConsumerConfigData.getConsumerGroupId())).start();
	}
	
	
	@Override
	@KafkaListener(id = "${kafka-consumer-config.consumer-group-id}", topics = "${kafka-config.topic-name}")
	public void recieve(
			@Payload 									List<StreamAvroModel> 	messages,
			@Header(KafkaHeaders.RECEIVED_KEY) 			List<String> keys,
			@Header(KafkaHeaders.RECEIVED_PARTITION) 	List<Integer> partitions,
			@Header(KafkaHeaders.OFFSET) 				List<Long> offsets) {
		// TODO Auto-generated method stub
		
		
		LOG.info("{} number of stream requests received with keys:{}, partitions:{} and offsets: {}",
				 	messages.size(),
	                keys.toString(),
	                partitions.toString(),
	                offsets.toString());
		
		
		
		messages.forEach(streamAvroModel ->{
			List<StreamAvroModel> streamAvroModels = messages; 
			List<Stream> streams = streamConsumerMessageMapper.mapStreamFromStreamAvroModel(streamAvroModels);
			//streamMessageElasticServiceRepos.save(streams);
			List<Stream> persistedStreams = streamRepository.saveAll(streams);
			LOG.info("StreamKafkaMessageListener: Total number of record inserted into the database: {}", persistedStreams.size());
			LOG.info("StreamKafkaMessageListener: Persisted Records : {}", persistedStreams);
			
		});
	}
}
