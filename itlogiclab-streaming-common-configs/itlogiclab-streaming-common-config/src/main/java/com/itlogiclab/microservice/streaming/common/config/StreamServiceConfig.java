package com.itlogiclab.microservice.streaming.common.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "stream.config")
public class StreamServiceConfig {

	private List<String> filterKeywords;
	private Boolean 	 enableStream; 
	private Integer 	 minLength;
	private Integer 	 maxLength;
	private Long 		 sleepMs;
	private boolean 	 filteRequired;
	/**
	 * @return the filterKeywords
	 */
	public List<String> getFilterKeywords() {
		return filterKeywords;
	}
	/**
	 * @return the enableStream
	 */
	public Boolean getEnableStream() {
		return enableStream;
	}
	/**
	 * @return the minLength
	 */
	public Integer getMinLength() {
		return minLength;
	}
	/**
	 * @return the maxLength
	 */
	public Integer getMaxLength() {
		return maxLength;
	}
	/**
	 * @return the sleepMs
	 */
	public Long getSleepMs() {
		return sleepMs;
	}
	/**
	 * @return the filteRequired
	 */
	public boolean isFilteRequired() {
		return filteRequired;
	}
	/**
	 * @param filterKeywords the filterKeywords to set
	 */
	public void setFilterKeywords(List<String> filterKeywords) {
		this.filterKeywords = filterKeywords;
	}
	/**
	 * @param enableStream the enableStream to set
	 */
	public void setEnableStream(Boolean enableStream) {
		this.enableStream = enableStream;
	}
	/**
	 * @param minLength the minLength to set
	 */
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	/**
	 * @param sleepMs the sleepMs to set
	 */
	public void setSleepMs(Long sleepMs) {
		this.sleepMs = sleepMs;
	}
	/**
	 * @param filteRequired the filteRequired to set
	 */
	public void setFilteRequired(boolean filteRequired) {
		this.filteRequired = filteRequired;
	}
	@Override
	public String toString() {
		return "StreamServiceConfig [filterKeywords=" + filterKeywords + ", enableStream=" + enableStream
				+ ", minLength=" + minLength + ", maxLength=" + maxLength + ", sleepMs=" + sleepMs + ", filteRequired="
				+ filteRequired + "]";
	}

}
