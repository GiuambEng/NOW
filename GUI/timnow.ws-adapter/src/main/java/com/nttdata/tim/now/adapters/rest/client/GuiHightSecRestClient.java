package com.nttdata.tim.now.adapters.rest.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1233
@Component
public class GuiHightSecRestClient extends RestClientBase {

	@Value("${rest.client.hightsec.baseurl}")
	private String baseUrl;

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

}
