package com.nttdata.tim.now.web.configuration;

import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nttdata.tim.now.util.SystemHelper;
import com.nttdata.tim.now.util.logging.LogbackHelper;
import com.nttdata.tim.now.util.spring.SpringHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitApplicationListener implements ServletContextListener {

	private static final String MANIFEST_LOCATION = "/META-INF/MANIFEST.MF";
	private static final String BUILD_ID = "Build-Id";
	private static final String IMPLEMENTATION_VERSION = "Implementation-Version";
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		destroySpringContext();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LogbackHelper.configure();
		logger.info("Start Spring context...");
		initSpringContext(event);
		logger.info("Spring context loaded. Application started.");
		SystemHelper.logMemoryInformation();
	}

	private void logAppVersion(ServletContext servletContext) {
		try (InputStream inputStream = servletContext.getResourceAsStream(MANIFEST_LOCATION)) {
			Manifest manifest = new Manifest(inputStream);
			Attributes attrs = manifest.getMainAttributes();

			String implementationVersion = attrs.getValue(IMPLEMENTATION_VERSION);
			logger.info("******************************************");
			logger.info("\tImplementation-Version: " + implementationVersion);
			String revisionNumber = attrs.getValue(BUILD_ID);
			logger.info("\tRevision-Number: " + revisionNumber);
			logger.info("******************************************");
		} catch (Exception e) {
			logger.info("unable to access MANIFEST file", e);
		}
	}

	private void initSpringContext(ServletContextEvent event) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		SpringHelper.setApplicationContext((ApplicationContext) webApplicationContext);
		logAppVersion(event.getServletContext());
	}

	private void destroySpringContext() {
		SpringHelper.clearWebApplicationContext();
	}
}
