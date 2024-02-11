package com.itlogiclab.microservice.streaming.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elastic.config")
public class ElasticConfigData {
	private String 		indexName; 
	private String 		connectionUrl; 
	private Integer 	connectTimeoutMs; 
	private Integer 	socketTimeoutMs;
	
	
	public ElasticConfigData() {
		// TODO Auto-generated constructor stub
	}
	
	public ElasticConfigData(Builder builder) {
		this.indexName		 	= builder.indexName;
		this.connectionUrl 		= builder.connectionUrl;
		this.connectTimeoutMs 	= builder.connectTimeoutMs;
		this.socketTimeoutMs 	= builder.socketTimeoutMs;
	}
	/**
	 * @return the indexName
	 */
	public String getIndexName() {
		return indexName;
	}
	/**
	 * @param indexName the indexName to set
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	/**
	 * @return the connectionUrl
	 */
	public String getConnectionUrl() {
		return connectionUrl;
	}
	/**
	 * @param connectionUrl the connectionUrl to set
	 */
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
	/**
	 * @return the connectTimeoutMs
	 */
	public Integer getConnectTimeoutMs() {
		return connectTimeoutMs;
	}
	/**
	 * @param connectTimeoutMs the connectTimeoutMs to set
	 */
	public void setConnectTimeoutMs(Integer connectTimeoutMs) {
		this.connectTimeoutMs = connectTimeoutMs;
	}
	/**
	 * @return the socketTimeoutMs
	 */
	public Integer getSocketTimeoutMs() {
		return socketTimeoutMs;
	}
	/**
	 * @param socketTimeoutMs the socketTimeoutMs to set
	 */
	public void setSocketTimeoutMs(Integer socketTimeoutMs) {
		this.socketTimeoutMs = socketTimeoutMs;
	}
	@Override
	public String toString() {
		return "ItlogiclabElasticConfigData [indexName=" + indexName + ", connectionUrl=" + connectionUrl
				+ ", connectTimeoutMs=" + connectTimeoutMs + ", socketTimeoutMs=" + socketTimeoutMs + "]";
	}
	public static Builder builder() {
		return new Builder();
	}

	
	public static final class Builder {
		private String indexName;
		private String connectionUrl;
		private Integer connectTimeoutMs;
		private Integer socketTimeoutMs;

		private Builder() {
		}

		public Builder withIndexName(String indexName) {
			this.indexName = indexName;
			return this;
		}

		public Builder withConnectionUrl(String connectionUrl) {
			this.connectionUrl = connectionUrl;
			return this;
		}

		public Builder withConnectTimeoutMs(Integer connectTimeoutMs) {
			this.connectTimeoutMs = connectTimeoutMs;
			return this;
		}

		public Builder withSocketTimeoutMs(Integer socketTimeoutMs) {
			this.socketTimeoutMs = socketTimeoutMs;
			return this;
		}

		public ElasticConfigData build() {
			return new ElasticConfigData(this);
		}
	} 

}
