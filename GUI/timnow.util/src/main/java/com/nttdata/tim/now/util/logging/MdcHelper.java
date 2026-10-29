package com.nttdata.tim.now.util.logging;

import org.slf4j.MDC;

public class MdcHelper {

	private MdcHelper() {
	}

	public static void put(String parameterName, String parameterValue) {
		MDC.put(parameterName, parameterValue);
	}

	public static String get(String parameterName) {
		return MDC.get(parameterName);
	}

	public static void remove(String parameterName) {
		MDC.remove(parameterName);
	}
	
}