package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficafwaeolo.ListaAnagraficaFwaEoloOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1479
@Component
public class AnagraficaFwaEoloRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.integration.anagrafica.fwa_eolo.contextpath}")
	private String anagraficaFwaEoloContextPath;	
	
	@Value("${auth.rest.integration.anagrafica.fwa_eolo.contextpath}")
	private String authAnagraficaFwaEoloContextPath;
	
	public ListaAnagraficaFwaEoloOutputDTO getList(String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authAnagraficaFwaEoloContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAnagraficaFwaEoloContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(anagraficaFwaEoloContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAnagraficaFwaEoloOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
