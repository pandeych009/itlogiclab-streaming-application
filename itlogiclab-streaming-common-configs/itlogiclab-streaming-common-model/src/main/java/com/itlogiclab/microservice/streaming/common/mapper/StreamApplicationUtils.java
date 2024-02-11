package com.itlogiclab.microservice.streaming.common.mapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StreamApplicationUtils {
	
	public static final String UTC_TZ = "UTC";
	
	public static ZonedDateTime CURRENT_DATE = ZonedDateTime.now(ZoneId.of(UTC_TZ));
	
	private StreamApplicationUtils() {
		// Only static methods or constants
	}
}
