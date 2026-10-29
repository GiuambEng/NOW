package com.nttdata.tim.now.util.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogbackHelper{
	
	private static final Logger logger = LoggerFactory.getLogger(LogbackHelper.class);

	private LogbackHelper() {
	}

	public static void configure(){
		
		try{
			LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
			ContextInitializer ci = new ContextInitializer(lc);
			
			lc.reset();
		    ci.autoConfig();
		    StatusPrinter.print(lc);
		    lc.start();
		   
			logger.info("Configure Logback ....<OK>");
		}catch (JoranException e){
		    logger.debug(e.getMessage(), e);
		}catch (NullPointerException npe){
			logger.error("Errore di configurazione verificare che le property siano correttamente inserite.", npe);
		}
		
	}

	
}
