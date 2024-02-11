package com.itlogiclab.microservice.streaming.consumer.dataaccess.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stream")
public class StreamEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; 
	@Column(name = "user_id")
	private Long userId; 
	@Column(name = "text_data")
	private String text;
	@Column(name = "created_at")
	private ZonedDateTime createdAt;
	
	public StreamEntity() {
		// TODO Auto-generated constructor stub
	}

	private StreamEntity(Builder builder) {
		this.id 			= builder.id;
		this.userId 		= builder.userId;
		this.text 			= builder.text;
		this.createdAt 		= builder.createdAt;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the createdAt
	 */
	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long 			id;
		private Long 			userId;
		private String 			text;
		private ZonedDateTime 	createdAt;

		private Builder() {
		}

		public Builder withId(Long id) {
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

		public Builder withCreatedAt(ZonedDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public StreamEntity build() {
			return new StreamEntity(this);
		}
	}
}
