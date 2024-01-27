package com.itlogiclab.microservice.streaming.common.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "stream.kafka.config")
public class KafkaStreamServiceConfig {
	
	private List<String> 	filterKeywords;
	private Boolean 		enableStreams; 
	private Integer 		mockMinStreamLength;
	private Integer 		mockMaxStreamLength;
	private Long 			mockSleepMs;
	private boolean 		filterRequired;
	
	
	/**
	 * @return the enableStreams
	 */
	public Boolean getEnableStreams() {
		return enableStreams;
	}
	/**
	 * @return the mockMinStreamLength
	 */
	public Integer getMockMinStreamLength() {
		return mockMinStreamLength;
	}
	/**
	 * @return the mockMaxStreamLength
	 */
	public Integer getMockMaxStreamLength() {
		return mockMaxStreamLength;
	}
	/**
	 * @return the mockSleepMs
	 */
	public Long getMockSleepMs() {
		return mockSleepMs;
	}
	
	/**
	 * @param enableStreams the enableStreams to set
	 */
	public void setEnableStreams(Boolean enableStreams) {
		this.enableStreams = enableStreams;
	}
	/**
	 * @param mockMinStreamLength the mockMinStreamLength to set
	 */
	public void setMockMinStreamLength(Integer mockMinStreamLength) {
		this.mockMinStreamLength = mockMinStreamLength;
	}
	/**
	 * @param mockMaxStreamLength the mockMaxStreamLength to set
	 */
	public void setMockMaxStreamLength(Integer mockMaxStreamLength) {
		this.mockMaxStreamLength = mockMaxStreamLength;
	}
	/**
	 * @param mockSleepMs the mockSleepMs to set
	 */
	public void setMockSleepMs(Long mockSleepMs) {
		this.mockSleepMs = mockSleepMs;
	}
	/**
	 * @return the filterKeywords
	 */
	public List<String> getFilterKeywords() {
		return filterKeywords;
	}
	/**
	 * @param filterKeywords the filterKeywords to set
	 */
	public void setFilterKeywords(List<String> filterKeywords) {
		this.filterKeywords = filterKeywords;
	}
	/**
	 * @return the filterRequired
	 */
	public boolean isFilterRequired() {
		return filterRequired;
	}
	/**
	 * @param filterRequired the filterRequired to set
	 */
	public void setFilterRequired(boolean filterRequired) {
		this.filterRequired = filterRequired;
	}

}
