package com.nttdata.tim.now.adapters.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuiIntegrationRestClient extends RestClientBase {

	@Value("${rest.client.baseurl}")
	private String baseUrl;

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

}
