package com.itlogiclab.microservice.streaming.producer.service.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.itlogiclab.microservice.common.domain.entity.AggregateRoot;

public class Stream extends AggregateRoot<Long>{
	
	private String 			data;
	private Long            userId; 
	private ZonedDateTime   createdAt;
	
	private Stream(StreamingEntityBuilder builder) {
		setId(builder.id);
		this.data 		= builder.data;
		this.userId 	= builder.userId;
		this.createdAt 	= builder.createdAt;
	}
	
	
	public void initializeStreamingEntity() {
		Long idValue = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE; 
		setId(idValue);
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @return the createdAt
	 */
	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Stream [data=" + data + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}


	public static StreamingEntityBuilder builder() {
		return new StreamingEntityBuilder();
	}

	public static final class StreamingEntityBuilder {
		private Long 			id;
		private String 			data;
		private Long 			userId;
		private ZonedDateTime 	createdAt;

		private StreamingEntityBuilder() {
		}

		public StreamingEntityBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public StreamingEntityBuilder withData(String data) {
			this.data = data;
			return this;
		}

		public StreamingEntityBuilder withUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		public StreamingEntityBuilder withCreatedAt(ZonedDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Stream build() {
			return new Stream(this);
		}
	} 

}
