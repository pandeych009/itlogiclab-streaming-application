package com.itlogiclab.microservice.common.config.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class ItlogiclabStreamConfigServer {

	private static Logger logger = LoggerFactory.getLogger(ItlogiclabStreamConfigServer.class);
	public static void main(String[] args) {
		logger.info("ItlogiclabStreamConfigServer: Running config server");
		SpringApplication.run(ItlogiclabStreamConfigServer.class, args);
	}
	
}
