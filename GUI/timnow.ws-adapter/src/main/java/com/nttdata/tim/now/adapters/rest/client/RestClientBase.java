package com.nttdata.tim.now.adapters.rest.client;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.nttdata.tim.now.adapters.exception.AuthSSLRuntimeException;
import com.nttdata.tim.now.adapters.rest.configuration.RestClientConfiguration;
import com.nttdata.tim.now.adapters.rest.filters.LoggingFilter;
import com.nttdata.tim.now.adapters.rest.filters.MdcFilter;
import com.nttdata.tim.now.adapters.rest.filters.RequestEnhancerFilter;
import com.nttdata.tim.now.adapters.rest.filters.statistic.StatisticFilter;
import com.nttdata.tim.now.data.enumeration.SSLPolicy;
import com.nttdata.tim.now.util.properties.PropertiesHelper;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public abstract class RestClientBase implements InitializingBean {

	private static final String JKS = "JKS";
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private String baseURL;
	private Client client;

	@Value("${rest.connection_timeout}")
	protected String connectionTimeout;

	@Value("${ws.keyStorePassword}")
	protected String keyStorePassword;

	@Value("${rest.read_timeout}")
	protected String readTimeout;

	@Value("${ws.sslPolicy}")
	protected String sslPolicy;

	@Value("${ws.keyStoreKeyPassword}")
	protected String keyStoreKeyPassword;

	@Value("${ws.keyStoreFileLocation}")
	protected String keyStoreFileLocation;

	@Value("${ws.trustStoreFileLocation}")
	protected String trustStoreFileLocation;

	@Value("${ws.trustStorePassword}")
	protected String trustStorePassword;

	@Override
	public void afterPropertiesSet() throws Exception {
		RestClientConfiguration config = this.getRestClientConfiguration();

		if (null == config) {
			throw new NullPointerException("La configurazione rest client non valorizzata");
		}

		this.baseURL = config.getBaseURL();
		this.client = getClient(config);

		logger.debug("REST client init complete.");
	}

	/**
	 * Configura il baseurl del WebTarget.
	 * 
	 * @return
	 */
	public WebTarget getBaseTarget() {
		return client.target(baseURL);
	}

	/**
	 * Ritorna la configurazione del rest client.
	 * 
	 * @return
	 */
	public RestClientConfiguration getRestClientConfiguration() {
		RestClientConfiguration config = new RestClientConfiguration();
		config.setBaseURL(getBaseUrl());
		config.setConnectionTimeout(connectionTimeout);
		config.setReadTimeout(readTimeout);
		config.setSslPolicy(sslPolicy);
		config.setKeyPassword(keyStoreKeyPassword);
		config.setKeyStoreFile(keyStoreFileLocation);
		config.setKeyStorePassword(keyStorePassword);
		config.setTrustStoreFile(trustStoreFileLocation);
		config.setTrustStorePassword(trustStorePassword);
		return config;
	}

	/**
	 * Ritorna la configurazione del base URL.
	 * 
	 * @return String base URL
	 */
	protected abstract String getBaseUrl();
	
	
	/**
	 * Ritorna una istanza configurata del client http.
	 * 
	 * @param clientConfig
	 * @return
	 */
	public Client getClient(final RestClientConfiguration config) {
		Client selectedClient;

		ClientConfig clientConfig = configureClient(config);

		if (config.isSecure()) {
			HostnameVerifier hostnameVerifier = new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			};

			final SSLContext sslContext = configureSSL(config);
			selectedClient = ClientBuilder.newBuilder().withConfig(clientConfig).sslContext(sslContext)
					.hostnameVerifier(hostnameVerifier).build();
		} else {
			selectedClient = ClientBuilder.newClient(clientConfig);
		}

		selectedClient.register(JacksonJsonProvider.class);

		return selectedClient;
	}

	/**
	 * Definisce la confugurazione del client http.
	 * 
	 * @return ClientConfig
	 *   configurazione del client 
	 */
	protected ClientConfig configureClient(final RestClientConfiguration config) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeatures.class);
		clientConfig.register(LoggingFilter.class);
		clientConfig.register(MdcFilter.class);
		clientConfig.register(RequestEnhancerFilter.class);
		clientConfig.register(StatisticFilter.class);
		logger.info("Registered RESTLoggingFilter filters");
		clientConfig.property(ClientProperties.READ_TIMEOUT, config.getReadTimeout());
		logger.info("REST client read timeout set to {}", config.getReadTimeout());
		clientConfig.property(ClientProperties.CONNECT_TIMEOUT, config.getConnectionTimeout());
		logger.info("REST client connection timeout set to {}", config.getConnectionTimeout());
		return clientConfig;
	}

	/**
	 * Crea il contesto SSL in base alla configurazione della applicazione.
	 * 
	 * @return
	 */
	protected SSLContext configureSSL(final RestClientConfiguration config) {
		SSLContext sslContext;

		SSLPolicy sslPolicyLocal = config.getSslPolicy();

		if (SSLPolicy.MUTUAL == sslPolicyLocal) {
			sslContext = createSSLContextChecked(config);
		} else if (SSLPolicy.EASY == sslPolicyLocal) {
			sslContext = createSSLContextUnchecked();
		} else {
			if (!PropertiesHelper.isLOCAL() && !PropertiesHelper.isDEVELOPMENT()) {
				throw new AuthSSLRuntimeException("Policy ssl non riconosciute " + sslPolicyLocal);
			}
			sslContext = createSSLContextUnchecked();
		}

		return sslContext;
	}

	/**
	 * Crea un SSL context che gestisce l'autenticazione SSL in modalita one way
	 * or two way.
	 * 
	 * @return
	 */
	private SSLContext createSSLContextChecked(final RestClientConfiguration config) {
		SslConfigurator sslConfig = SslConfigurator.newInstance().
				keyStoreFile(config.getKeyStoreFile()).
				keyStorePassword(config.getKeyStorePassword()).
				keyStoreType(JKS).
				keyManagerFactoryAlgorithm(KeyManagerFactory.getDefaultAlgorithm()).
				trustStoreFile(config.getTrustStoreFile()).
				trustStorePassword(config.getTrustStorePassword()).
				trustStoreType(JKS).
				trustManagerFactoryAlgorithm(TrustManagerFactory.getDefaultAlgorithm());
			
		if (StringUtils.isNotBlank(config.getKeyPassword())) {
			sslConfig.keyPassword(config.getKeyPassword());
		}

		return sslConfig.createSSLContext();
	}

	/**
	 * Crea un SSL context che accetta certificati self-signed. Non utilizzare
	 * questo metodo per i sistemi di produzione.
	 * 
	 * @return
	 */
	private SSLContext createSSLContextUnchecked() {
		SSLContext sslContext = null;
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			@Override
		    public X509Certificate[] getAcceptedIssuers(){return null;}
			@Override
		    public void checkClientTrusted(X509Certificate[] certs, String authType){/*do nothing*/}
			@Override
		    public void checkServerTrusted(X509Certificate[] certs, String authType){/*do nothing*/}
		}};

		// Install the all-trusting trust manager
		try {
			sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, trustAllCerts, new SecureRandom());
		} catch (Exception e) {
			logger.error("Impossibile configurare le policy SSL", e);
		}
		return sslContext;
	}

}
