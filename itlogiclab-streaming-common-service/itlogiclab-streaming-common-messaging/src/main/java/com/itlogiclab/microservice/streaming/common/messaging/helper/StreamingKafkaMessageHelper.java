package com.itlogiclab.microservice.streaming.common.messaging.helper;

import java.util.function.BiConsumer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlogiclab.microservice.streaming.common.domain.exception.StreamDomainException;
import com.itlogiclab.microservice.streaming.common.domain.valueobject.StreamStatus;

@Component
public class StreamingKafkaMessageHelper {
	
	private static Logger logger = LoggerFactory.getLogger(StreamingKafkaMessageHelper.class);

	private final ObjectMapper objectMapper;

	public StreamingKafkaMessageHelper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	} 
	
	public <T> T getEventPayload(String payload, Class<T> outputType) {
		try {
			return objectMapper.readValue(payload, outputType);
		} catch (JsonProcessingException e) {
			logger.error("Could not read {} object!", outputType.getName(), e);
			throw new StreamDomainException("Could not read " + outputType.getName() + " object!", e);
		}
	}
	
	
	public <T, U> BiConsumer<SendResult<String, T>, Throwable> getKafkaCallback(String responseTopicName, 
																				T avroModel, 
																				U streamMessage,
																				BiConsumer<U, StreamStatus> streamCallback,
																				String streamId, 
																				String avroModelName) {
        return (result, ex) -> {
            if (ex == null) {
                RecordMetadata metadata = result.getRecordMetadata();
                logger.info("Received successful response from Kafka for order id: {}" +
                                " Topic: {} Partition: {} Offset: {} Timestamp: {}",
                                streamId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp());
                streamCallback.accept(streamMessage, StreamStatus.COMPLETED);
            } else {
            	logger.error("Error while sending {} with message: {} and outbox type: {} to topic {}",
                        avroModelName, avroModel.toString(), streamMessage.getClass().getName(), responseTopicName, ex);
                streamCallback.accept(streamMessage, StreamStatus.FAILED);
            }
        };
    }
	
}
