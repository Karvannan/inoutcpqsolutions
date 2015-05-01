package com.inoutcorp.cpq.opportunity.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtils {

	private static final Logger LOGGER = Logger.getLogger(JSONUtils.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static final String getJSONStringFromObject(Object object) {
		if (object != null) {
			try {
				return objectMapper.writeValueAsString(object);
			} catch (JsonGenerationException e) {
				LOGGER.error("JsonGenerationException occurred ", e);
			} catch (JsonMappingException e) {
				LOGGER.error("JsonMappingException occurred ", e);
			} catch (IOException e) {
				LOGGER.error("IOException occurred ", e);
			}
		}
		return null;
	}

	public static final <T> T getObjectFromJSONString(String jsonString,
			Class<T> className) {
		if (jsonString != null && !"".equalsIgnoreCase(jsonString)
				&& className != null) {
			try {
				return objectMapper.readValue(jsonString, className);
			} catch (JsonParseException e) {
				LOGGER.error("JsonParseException occurred ", e);
			} catch (JsonMappingException e) {
				LOGGER.error("JsonMappingException occurred ", e);
			} catch (IOException e) {
				LOGGER.error("IOException occurred ", e);
			}
		}
		return null;
	}

	public static final <T> T convertObject(Object sourceObject,
			Class<T> destinationClass) {
		if (sourceObject != null && destinationClass != null) {
			try {
				String jsonString = JSONUtils
						.getJSONStringFromObject(sourceObject);
				return objectMapper.readValue(jsonString, destinationClass);
			} catch (JsonParseException e) {
				LOGGER.error("JsonParseException occurred ", e);
			} catch (JsonMappingException e) {
				LOGGER.error("JsonMappingException occurred ", e);
			} catch (IOException e) {
				LOGGER.error("IOException occurred ", e);
			}
		}
		return null;
	}

}
