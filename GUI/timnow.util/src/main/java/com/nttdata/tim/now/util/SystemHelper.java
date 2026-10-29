package com.nttdata.tim.now.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemHelper {
	private static final String MB_LABEL = " MB ) - ";
	private static final String KBYTE_LABEL = " KB / ";
	private static final String BYTE_LABEL = " B / ";
	private static final Logger logger = LoggerFactory.getLogger(SystemHelper.class);

	private SystemHelper() {
	}

	public static PrintStream getPrintStreamEmpty() {
		return new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				//nothing to do
			}
		});
	}

	public static void logMemoryInformation() {

		Runtime runtime = Runtime.getRuntime();

		long div = 1024L;
		long maxMemoryByte = runtime.maxMemory();
		long allocatedMemoryByte = runtime.totalMemory();
		long freeMemoryByte = runtime.freeMemory();
		long maxMemoryKByte = maxMemoryByte / div;
		long allocatedMemoryKByte = allocatedMemoryByte / div;
		long freeMemoryKByte = freeMemoryByte / div;
		long maxMemoryMByte = maxMemoryKByte / div;
		long allocatedMemoryMByte = allocatedMemoryKByte / div;
		long freeMemoryMByte = freeMemoryKByte / div;
		double freeMemoryPercent = ((double) freeMemoryByte) / maxMemoryByte * 100;
		double allocatedMemoryPercent = ((double) allocatedMemoryByte) / maxMemoryByte * 100;
		double usedMemoryPercent = ((double) allocatedMemoryByte - freeMemoryByte) / maxMemoryByte * 100;
		

		DecimalFormat df = new DecimalFormat("#.##");
		StringBuilder memory = new StringBuilder("MEMORYINFORMATION:<").
				append("FreeMemory=(").append(freeMemoryByte).append(BYTE_LABEL).append(freeMemoryKByte).append(KBYTE_LABEL).append(freeMemoryMByte).append(MB_LABEL)
				.append("AllocatedMemory=(").append(allocatedMemoryByte).append(BYTE_LABEL).append(allocatedMemoryKByte).append(KBYTE_LABEL).append(allocatedMemoryMByte).append(MB_LABEL)
				.append("MaxMemory=(").append(maxMemoryByte).append(BYTE_LABEL).append(maxMemoryKByte).append(KBYTE_LABEL).append(maxMemoryMByte).append(MB_LABEL)
				.append("Percent=(").append(df.format(freeMemoryPercent)).append("% Free / ").append(df.format(allocatedMemoryPercent)).append("% Allocated / ")
				.append(df.format(usedMemoryPercent)).append("% Used)>");
		logger.debug(memory.toString());
		
		StringBuilder systemInfo = new StringBuilder("SYSTEMDETAILS:<").append("cpus=").append(getCpusNumber()).append(", threads limit=").append(getTreadsNumberToUse());
		logger.debug(systemInfo.toString());
		
		
	}

	public static int getCpusNumber() {
		return Runtime.getRuntime().availableProcessors();
	}

	public static int getTreadsNumberToUse() {
		return getCpusNumber() + 1;
	}

	public static String getCurrentPath() {
		String currentPath = SystemHelper.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		currentPath = getOnlyPath(currentPath);
		return currentPath;
	}

	public static String getOnlyPath(String currentPath) {
		int positionSLASH = currentPath.lastIndexOf('/');
		String path = new String(currentPath);
		if (positionSLASH != -1) {
			path = currentPath.substring(0, positionSLASH + 1);
		}
		int positionBACKSLASH = currentPath.lastIndexOf("\\");
		if (positionBACKSLASH != -1) {
			path = currentPath.substring(0, positionBACKSLASH + 1);
		}
		return path;
	}

	public static void setProperty(String name, String value) {
		System.setProperty(name, value);
	}

	public static String getProperty(String name) {
		return System.getProperty(name);
	}

	public static String getEnvironment() {
		String environment = System.getProperty(Constants.ENVIRONMENT_SYSTEM_PROPERTY);
		logger.debug("environment:<" + environment + ">");
		if (PropertiesHelper.LOCAL.equals(environment) || 
				PropertiesHelper.TEST.equals(environment) || 
				PropertiesHelper.INTEGRATION.equals(environment) || 
				PropertiesHelper.PRODUCTION.equals(environment)) {
			return environment;
		} else {
			logger.debug("configured environment is not valid! See PropertiesHelper constants! <" + environment + ">");
		}
		return null;
	}

	public static String getConfigFilePath() {
		String configPath = System.getProperty(Constants.CONFIGPATH_SYSTEM_PROPERTY);
		logger.debug(configPath);
		if (StringUtils.isNotEmpty(configPath)) {
			if (!configPath.endsWith("\\") && !configPath.endsWith("/")) {
				return configPath + "/";
			}
			return configPath;
		} else {
			logger.debug("empty configuration file path! check JVM property <" + Constants.CONFIGPATH_SYSTEM_PROPERTY + ">");
		}
		return null;
	}
}
