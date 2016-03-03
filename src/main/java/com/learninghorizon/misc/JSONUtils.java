package com.learninghorizon.misc;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JSONUtils {

	private static final String EMPTY_JSON="{}";
	
	private JSONUtils(){
		throw new AssertionError(
			"Don't try to access Private constructor."
		);
	}
	
	public static 
	String convertMapToString(final Map<String, Object> map){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.writerWithDefaultPrettyPrinter()
							   .writeValueAsString(map);
		} catch (final JsonProcessingException processingException) {
			processingException.printStackTrace();
		}
		return EMPTY_JSON;
	}
}
