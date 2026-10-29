package com.nttdata.tim.now.adapters.rest.configuration;

import com.nttdata.tim.now.data.enumeration.SSLPolicy;

public class RestClientConfiguration {

	private String readTimeout;
	private String connectionTimeout;
	private String baseURL;
	private String keyPassword;
	private String keyStoreFile;
	private String keyStorePassword;
	private String trustStoreFile;
	private String trustStorePassword;
	private SSLPolicy sslPolicy;

	public String getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(String readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(String connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getKeyPassword() {
		return keyPassword;
	}

	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}

	public String getKeyStoreFile() {
		return keyStoreFile;
	}

	public void setKeyStoreFile(String keyStoreFile) {
		this.keyStoreFile = keyStoreFile;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getTrustStoreFile() {
		return trustStoreFile;
	}

	public void setTrustStoreFile(String trustStoreFile) {
		this.trustStoreFile = trustStoreFile;
	}

	public String getTrustStorePassword() {
		return trustStorePassword;
	}

	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	public boolean isSecure() {
		return baseURL != null && baseURL.startsWith("https");
	}

	public SSLPolicy getSslPolicy() {
		return sslPolicy;
	}

	public void setSslPolicy(SSLPolicy sslPolicy) {
		this.sslPolicy = sslPolicy;
	}

	public void setSslPolicy(String sslPolicy) {
		this.sslPolicy = SSLPolicy.getPolicyByIdentifier(sslPolicy);
	}
	
}
