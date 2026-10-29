package com.nttdata.tim.now.util.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class SpringHelper {

	public static final String SCOPE_PROTOTYPE = "prototype";
	public static final String SCOPE_SINGLETON = "singleton";

	private static ClassPathXmlApplicationContext classpathApplicationContext;
	private static ApplicationContext webApplicationContext;

	public static Object getBean(String beanName) {
		Object object = null;
		if (webApplicationContext != null) {
			object = webApplicationContext.getBean(beanName);
		} else {
			object = classpathApplicationContext.getBean(beanName);
		}
		return object;
	}

	public static void setApplicationContext(ApplicationContext context) {
		if (webApplicationContext == null) {
			webApplicationContext = context;
		}
	}

	public static ApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	public static synchronized void clearWebApplicationContext() {
		webApplicationContext = null;
		classpathApplicationContext = null;
	}

	public void changeContextProfile(String newProfile) {
		if (webApplicationContext != null) {
			ConfigurableEnvironment env = ((ConfigurableApplicationContext) webApplicationContext)
					.getEnvironment();
			env.setActiveProfiles(newProfile);
			((ConfigurableApplicationContext) webApplicationContext).refresh();
		} else if (classpathApplicationContext != null) {
			ConfigurableEnvironment env = classpathApplicationContext
					.getEnvironment();
			env.setActiveProfiles(newProfile);
			classpathApplicationContext.refresh();
		}
	}

	public void refreshContext() {
		if (webApplicationContext != null) {
			((ConfigurableApplicationContext) webApplicationContext).refresh();
		} else if (classpathApplicationContext != null) {
			classpathApplicationContext.refresh();
		}
	}

}
