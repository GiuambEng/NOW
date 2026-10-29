package com.nttdata.tim.now.util.properties;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesHelper {

	public static final String LOCAL = "local";
	public static final String DEVELOPMENT = "development";
	public static final String TEST = "test";
	public static final String PRODUCTION = "production";
	public static final String INTEGRATION = "integration";

	private String environment;
	private Properties properties;
	private Properties authproperties;
	private Properties feProperties;

	private PropertiesHelper() {
		properties = new Properties();
		authproperties = new Properties();
		feProperties = new Properties();
	}

	private static class Contenitore {
		private static PropertiesHelper instance = new PropertiesHelper();

		private Contenitore() {
		}
	}

	private static PropertiesHelper getInstance() {
		return Contenitore.instance;
	}

	public static boolean isLOCAL() {
		String env = getEnvironment();
		return StringUtils.isEmpty(env) ? true : getEnvironment().equals(LOCAL);
	}

	public static boolean isDEVELOPMENT() {
		return getEnvironment().equals(DEVELOPMENT);
	}

	public static boolean isTEST() {
		return getEnvironment().equals(TEST);
	}

	public static boolean isPRODUCTION() {
		return getEnvironment().equals(PRODUCTION);
	}

	public static boolean isINTEGRATION() {
		return getEnvironment().equals(INTEGRATION);
	}

	public static void loadProperties(Properties properties) {
		getInstance().loadAllProperties(properties);
	}

	public static void loadAuthProperties(Properties properties) {
		getInstance().loadAllAuthProperties(properties);
	}

	public static void loadFEProperties(Properties properties) {
		getInstance().loadAllFEProperties(properties);
	}

	public static String getEnvironment() {
		return getInstance().environment;
	}

	public static void setEnvironment(String environment) {
		getInstance().environment = environment;
	}

	private void loadAllProperties(Properties properties) {
		this.properties = properties;
	}

	private void loadAllAuthProperties(Properties authproperties) {
		this.authproperties = authproperties;
	}

	private void loadAllFEProperties(Properties properties) {
		this.feProperties = properties;
	}

	public static Object getProperty(String name) {
		return getInstance().properties.get(name);
	}

	public static String getStringProperty(String name) {
		Object propertyObject = getProperty(name);
		if (propertyObject != null) {
			return (String) propertyObject;
		} else {
			return "";
		}
	}

	/**
	 * map string property with values "true/false" or "y/n" with boolean
	 * 
	 * @param propertyName
	 * @return true if property's value is true or y
	 */
	public static boolean getBooleanProperty(String name) {
		Object propertyObject = getProperty(name);
		if (propertyObject != null) {
			return "true".equalsIgnoreCase((String) propertyObject) || "y".equalsIgnoreCase((String) propertyObject);
		} else {
			return false;
		}
	}

	public static Properties getFEProperties() {
		return getInstance().feProperties;
	}

	public static Properties getAuthProperties() {
		return getInstance().authproperties;
	}

}
