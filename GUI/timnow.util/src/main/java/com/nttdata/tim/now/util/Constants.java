package com.nttdata.tim.now.util;

public class Constants {
	
	public static final String HEADER_USERNAME_VAR_PROPERTY = "header.var.username";
	public static final String HEADER_IP_VAR_PROPERTY = "header.var.clientIp";
	public static final String HEADER_PORT_VAR_PROPERTY = "header.var.clientPort";
	public static final String FILES_MANUALE_UTENTE_PATH = "files.manuale.utente.path";
	public static final String FILES_MANUALE_OLO_PATH = "files.manuale.olo.path";
	
	public static final String CONFIG_FILENAME = "config.properties";
	public static final String CONFIGAUTH_FILENAME = "configauth.properties";
	public static final String FECONFIG_FILENAME = "angularapp.properties";
	public static final String CONFIGPATH_SYSTEM_PROPERTY = "timnow.config.path";
	public static final String ENVIRONMENT_SYSTEM_PROPERTY = "timnow.environment";
	public static final String ENVIRONMENT = "environment";
	public static final String APPLICATION_NAME = "NOW";

	public static final String APPLICATION_OUT_DIR = "APPLICATION_OUT_DIR";
	public static final String APPLICATION_OUT_FILE = "APPLICATION_OUT_FILE";
	public static final String APPLICATION_LOG_LEVEL = "APPLICATION_LOG_LEVEL";

	/* APP */
	public static final String DEFAULT_OLO = "NO-OLO";
	public static final String DG_PROFILE = "CRM_DG";
	
	/*MDC*/
	public static final String MDC_LOG_PARAMETER_SID = "SID";
	public static final String MDC_LOG_PARAMETER_TID = "TID";
	public static final String MDC_LOG_PARAMETER_UID = "UID";
	public static final String MDC_LOG_PARAMETER_CLIENT_IP = "CLIENT_IP";
	public static final String MDC_LOG_PARAMETER_CLIENT_PORT = "CLIENT_PORT";
	public static final String MDC_LOG_PARAMETER_SRVC_URL = "SRVC-URL";
	public static final String MDC_LOG_PARAMETER_STATUS = "STATUS";
	public static final String MDC_LOG_PARAMETER_METHOD = "METHOD";
	public static final String MDC_LOG_PARAMETER_ELAPSED_TIME = "ELAPSED_TIME";
	
	/*log level constants*/
	public static final String LOG_STATISTICS_OUT_DIR = "LOG_STATISTICS_OUT_DIR";
	public static final String LOG_STATISTICS_OUT_FILE = "LOG_STATISTICS_OUT_FILE";
	public static final String LOG_STATISTICS_LEVEL = "LOG_STATISTICS_LEVEL";
	
	public static final String LOG_ROOT_LEVEL = "LOG_ROOT_LEVEL";

	public static final String LOG_LEVEL_OFF = "OFF";
	public static final String LOG_LEVEL_ERROR = "ERROR";
	public static final String LOG_LEVEL_WARN = "WARN";
	public static final String LOG_LEVEL_INFO = "INFO";
	public static final String LOG_LEVEL_DEBUG = "DEBUG";
	public static final String LOG_LEVEL_TRACE = "TRACE";
	
	public static final String LOGGER_NAME_STATISTICS = "statistics";
	public static final String LOGGER_NAME_TRACE = "trace";
	public static final String LOGGER_NAME_MONITORING = "monitoring";
	public static final String LOGGER_NAME_CACHEMONITORING = "cachemonitoring";

	/*cache*/
	public static final String IL_CACHE_NAME = "integrationLayerCache";
	public static final String BL_CACHE_NAME = "remedyCache";

	/*FE*/
	public static final String FE_TODAY_CONFIG_PROPERTY = "today";	
	
	//for getCoOrdineUnivoco
	public static final String ALPHANUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	
	private Constants() {
	}
}
