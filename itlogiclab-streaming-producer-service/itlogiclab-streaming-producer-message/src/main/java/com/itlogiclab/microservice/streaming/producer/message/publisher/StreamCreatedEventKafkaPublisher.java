package com.itlogiclab.microservice.streaming.producer.message.publisher;

import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itlogiclab.microservice.common.kafka.config.data.KafkaConfigData;
import com.itlogiclab.microservice.common.kafka.producer.service.KafkaProducer;
import com.itlogiclab.microservice.streaming.common.domain.entity.Stream;
import com.itlogiclab.microservice.streaming.common.domain.valueobject.StreamStatus;
import com.itlogiclab.microservice.streaming.kafka.avro.modal.StreamAvroModel;
import com.itlogiclab.microservice.streaming.producer.message.mapper.StreamAvroTransformer;
import com.itlogiclab.microservice.streaming.service.domain.ports.output.mesage.publisher.StreamRequestMessagePublisher;

@Component
public class StreamCreatedEventKafkaPublisher implements StreamRequestMessagePublisher{

	private static final Logger LOG = LoggerFactory.getLogger(StreamCreatedEventKafkaPublisher.class);

		private final StreamAvroTransformer  					streamAvroTransformer;
		private final KafkaConfigData 							kafkaConfigData;
		private final KafkaProducer<String, StreamAvroModel> 	kafkaProducer;
		
		public StreamCreatedEventKafkaPublisher(
				StreamAvroTransformer streamAvroTransformer,  
				KafkaConfigData kafkaConfigData, 
				KafkaProducer<String, StreamAvroModel> kafkaProducer
			) {
			super();
		    this.kafkaProducer 			= kafkaProducer;
			this.streamAvroTransformer 	= streamAvroTransformer;
			this.kafkaConfigData 		= kafkaConfigData;
		}

	@Override
	public void publish(Stream stream, BiConsumer<Stream, StreamStatus> streamCallBack) {
		try {	
			LOG.info("StreamCreatedEventKafkaPublisher: Start publishing message to Kafka");
			// TODO Auto-generated method stub
			StreamAvroModel streamAvroModel = streamAvroTransformer.buildStreamAvroModel(stream);
			kafkaProducer.send(kafkaConfigData.getTopicName(), stream.getUserId().toString(), streamAvroModel);
			LOG.info("StreamCreatedEventKafkaPublisher: Message has been pushed to kafka with topic: {}, Key: {}, Mesasge: {}", kafkaConfigData.getTopicName(), stream.getUserId(), streamAvroModel );
		} catch (Exception e) {
			LOG.error("Error while sending OrderApprovalEventPayload to kafka for order id:  and saga id:," +
					" error: {}", e.getMessage());
		}
	}

	@Override
	public void publish(Stream stream) {
		// TODO Auto-generated method stub
		publish(stream, null);
	} 

}
