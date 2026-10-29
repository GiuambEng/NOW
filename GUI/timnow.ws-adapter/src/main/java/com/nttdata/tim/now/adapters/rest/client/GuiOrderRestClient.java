package com.nttdata.tim.now.adapters.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuiOrderRestClient extends RestClientBase {

	@Value("${rest.client.order.baseurl}")
	private String baseUrl;

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

}
