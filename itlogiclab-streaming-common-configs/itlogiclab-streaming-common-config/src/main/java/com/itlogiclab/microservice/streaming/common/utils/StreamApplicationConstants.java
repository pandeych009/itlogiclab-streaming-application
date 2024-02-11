package com.itlogiclab.microservice.streaming.common.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class StreamApplicationConstants {
	
	private StreamApplicationConstants() {
		// TODO Auto-generated constructor stub
	}
	
	public static final String[] STREAM = new String[]{
            "Lorem",
            "ipsum",
            "dolor",
            "sit",
            "amet",
            "consectetuer",
            "adipiscing",
            "elit",
            "Maecenas",
            "porttitor",
            "congue",
            "massa",
            "Fusce",
            "posuere",
            "magna",
            "sed",
            "pulvinar",
            "ultricies",
            "purus",
            "lectus",
            "malesuada",
            "libero"
    };

    public static final String REQUEST_AS_RAW_JSON = "{" +
            "\"created_at\":\"{0}\"," +
            "\"id\":\"{1}\"," +
            "\"text\":\"{2}\"," +
            "\"user\":{\"id\":\"{3}\"}" +
            "}";
    
    public static final String REQUEST_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

}
