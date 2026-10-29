package com.nttdata.tim.now.web.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nttdata.tim.now.core.integrationlayer.PropertiesIL;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.util.Constants;
import com.nttdata.tim.now.util.SystemHelper;
import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesApplicationListener implements ServletContextListener {
			
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//nothing to do
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		boolean environmentRetrieved = false;
		String environment = SystemHelper.getEnvironment();
		if(StringUtils.isEmpty(environment)){
			environment = PropertiesHelper.LOCAL;
		}else{
			environmentRetrieved = true;
		}
		loadProperties(environment);
		if (!environmentRetrieved){
			logger.warn("Cannot load the environment!! Please set System property: "
					+ Constants.ENVIRONMENT_SYSTEM_PROPERTY + " with the correct environment value!");
		}
		logger.info("Properties loaded for environment:"+environment);
	}
	
	private void loadProperties(String environment){
		try {
			PropertiesIL.loadProperties(environment);
		} catch (IntegrationLayerException e) {
			logger.info(e.getMessage(), e);
		}
	}

}
