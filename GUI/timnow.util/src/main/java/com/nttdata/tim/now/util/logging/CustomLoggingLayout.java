package com.nttdata.tim.now.util.logging;

import org.apache.commons.lang3.StringUtils;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomLoggingLayout extends PatternLayout {

	private static final String[] CRLF = { "\r", "\n" };
	private static final String[] REPLACEMENTS = { " ", " " };

	/**
	 * Secure patterns to escape with "*": passed by logback.xml
	 */
	private String patternsProperty;

	public String getPatternsProperty() {
		return patternsProperty;
	}

	public void setPatternsProperty(String patternsProperty) {
		this.patternsProperty = patternsProperty;
	}

	public String doLayout(ILoggingEvent event) {
		// tutto l'evento logback: la loggata intera, non il solo "message"!
		String logbackEventMessage = super.doLayout(event);

		// loggo tutto su una riga: rimuovo carrier return e caratteri di fine
		// riga, aggiungendo comunque uno spazio
		return StringUtils.replaceEach(logbackEventMessage, CRLF, REPLACEMENTS) + " \r\n";

	}

}
