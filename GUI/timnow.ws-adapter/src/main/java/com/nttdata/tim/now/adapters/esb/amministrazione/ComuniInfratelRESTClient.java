package com.nttdata.tim.now.adapters.esb.amministrazione;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficainfratel.ListaAnagraficaComuneInfratelOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1078
@Component
public class ComuniInfratelRESTClient extends RestClientFacade {
	
	@Value("${rest.amministrazione.comuni.infratel.contextpath}")
	private String serviceContextPath;
		
	@Value("${auth.rest.amministrazione.comuni.infratel.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;


	public ListaAnagraficaComuneInfratelOutputDTO getList(String userId, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAnagraficaComuneInfratelOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
