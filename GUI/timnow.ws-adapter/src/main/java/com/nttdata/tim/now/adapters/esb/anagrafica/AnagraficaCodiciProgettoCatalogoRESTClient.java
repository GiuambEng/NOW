package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficacodiciprogettocatalogo.AnagraficaCodiciProgettoCatalogoWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1485
@Component
public class AnagraficaCodiciProgettoCatalogoRESTClient extends RestClientFacade {
	
	@Value("${rest.anagrafica.codiciprogettocatalogo.contextpath}")
	private String codiciProgettoCatalogoContextPath;
	
	@Value("${auth.rest.anagrafica.codiciprogettocatalogo.contextpath}")
	private String authCodiciProgettoCatalogoContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	public AnagraficaCodiciProgettoCatalogoWrapperOutputDTO listaCodiciProgettoCatalogo(String tipoProfilo) throws IntegrationLayerException {
		
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authCodiciProgettoCatalogoContextPath))
				&& (!isAuthorizedService(tipoProfilo, authCodiciProgettoCatalogoContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(codiciProgettoCatalogoContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(AnagraficaCodiciProgettoCatalogoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
