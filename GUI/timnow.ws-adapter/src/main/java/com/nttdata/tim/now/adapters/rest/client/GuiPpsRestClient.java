package com.nttdata.tim.now.adapters.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuiPpsRestClient extends RestClientBase {

	@Value("${rest.client.pps.baseurl}")
	private String baseUrl;

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

}
