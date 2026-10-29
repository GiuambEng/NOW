package com.nttdata.tim.now.core.integrationlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.SystemHelper;
import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesIL {
	private static Logger logger = LoggerFactory.getLogger(PropertiesIL.class);

	private PropertiesIL() {
	}

	public static void loadProperties() throws IntegrationLayerException {
		logger.debug("Reloading properties...");
		loadProperties(PropertiesHelper.getEnvironment());
		logger.debug("properties reloaded.");
	}

	public static void loadProperties(String environment) throws IntegrationLayerException {
		PropertiesHelper.setEnvironment(environment);

		PropertiesHelper.loadProperties(loadConfigProperties(SystemHelper.getConfigFilePath() + Constants.CONFIG_FILENAME));
		logger.debug("application properties loaded.");
		PropertiesHelper.loadAuthProperties(loadConfigProperties(SystemHelper.getConfigFilePath() + Constants.CONFIGAUTH_FILENAME));
		logger.debug("application auth properties loaded.");
		PropertiesHelper.loadFEProperties(loadConfigProperties(SystemHelper.getConfigFilePath() + Constants.FECONFIG_FILENAME));
		logger.debug("FE properties loaded.");
	}

	private static Properties loadConfigProperties(String configFileFullPath) throws IntegrationLayerException {
		Properties properties = new Properties();
		
		try (InputStream inputStream = new FileInputStream(configFileFullPath)) {
			logger.info("loading config file: " + configFileFullPath);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			logger.warn("Config file does not exist! " + configFileFullPath);
			throw new IntegrationLayerException(e);
		} catch (IOException e) {
			logger.warn("Cannot read Config file " + configFileFullPath);
			throw new IntegrationLayerException(e);
		}

		return properties;
	}

}
