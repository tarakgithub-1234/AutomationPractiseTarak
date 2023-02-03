package com.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4J {
	static Logger logger = LogManager.getLogger(Log4J.class);

	public static void main(String args[]) {
			logger.info("This is info message");
			logger.error("This is error message");
			logger.warn("This is warn message");
			logger.fatal("The is fatal message");
		}
}
