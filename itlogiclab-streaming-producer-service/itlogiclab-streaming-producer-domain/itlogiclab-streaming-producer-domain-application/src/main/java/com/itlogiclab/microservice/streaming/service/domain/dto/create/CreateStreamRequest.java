package com.itlogiclab.microservice.streaming.service.domain.dto.create;

import com.itlogiclab.microservice.streaming.producer.service.entity.StreamEntity;
public class CreateStreamRequest {
	
	private StreamEntity streamRequest;
	
	/**
	 * @return the streamRequest
	 */
	public StreamEntity getStreamRequest() {
		return streamRequest;
	}

	/**
	 * @param streamRequest the streamRequest to set
	 */
	public void setStreamRequest(StreamEntity streamRequest) {
		this.streamRequest = streamRequest;
	}

	private CreateStreamRequest(Builder builder) {
		this.streamRequest = builder.streamRequest;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private StreamEntity streamRequest;

		private Builder() {
		}

		public Builder withStreamRequest(StreamEntity streamRequest) {
			this.streamRequest = streamRequest;
			return this;
		}

		public CreateStreamRequest build() {
			return new CreateStreamRequest(this);
		}
	} 

}