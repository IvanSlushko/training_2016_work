package com.ivanslushko.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceTestLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTestLogger.class);
	
	public static void main(String[] args) {
		LOGGER.trace("trace");
		LOGGER.debug("debug");
		LOGGER.info("Hello this is an info message");
		LOGGER.warn("WARNING LOG to mail");
		LOGGER.error("ERROR LOG to mail");
		
	}
}