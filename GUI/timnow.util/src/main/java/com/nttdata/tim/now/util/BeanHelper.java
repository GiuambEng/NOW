package com.nttdata.tim.now.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanHelper {
	private static final Logger logger = LoggerFactory.getLogger(BeanHelper.class);

	private BeanHelper() {
	}

	/**
	 * print the object in JSON format
	 * 
	 * @param object
	 * @return
	 */

	public static String toString(Object object) {
		try {
			return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(object);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}
		return "";
	}

	/**
	 * return the simpleName of object
	 * 
	 * @param object
	 * @return
	 */
	public static String shortToString(Object object) {
		if (object != null) {
			return object.getClass().getSimpleName();
		} else {
			return "null";
		}
	}

}
