package com.itlogiclab.microservice.streaming.consumer.elastic.dataaccess.model;

import java.time.LocalDateTime;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itlogiclab.microservice.streaming.common.elastic.modal.IndexModel;

@Document(indexName = "#{@elasticConfigData.indexName}")
public class StreamIndexModel implements IndexModel {

	@JsonProperty
	private String id; 
	@JsonProperty
	private Long userId; 
	@JsonProperty
	private String text;

	@Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ")
	@JsonProperty
	private LocalDateTime createdAt;

	private StreamIndexModel(Builder builder) {
		this.id 			= builder.id;
		this.userId 		= builder.userId;
		this.text 			= builder.text;
		this.createdAt 		= builder.createdAt;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String 			id;
		private Long 			userId;
		private String 			text;
		private LocalDateTime 	createdAt;

		private Builder() {
		}

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withUserId(Long userId) {
			this.userId = userId;
			return this;
		}

		public Builder withText(String text) {
			this.text = text;
			return this;
		}

		public Builder withCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public StreamIndexModel build() {
			return new StreamIndexModel(this);
		}
	}
	
	

}
