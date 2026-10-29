package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficadisaggregazione.ListaAnagraficaDisaggregazioneOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnagDisaggregazioneRESTClient extends RestClientFacade {

	@Value("${rest.integration.anagraficadisaggregazione.contextpath}")
	private String serviceContextPath;

	@Value("${auth.rest.integration.anagraficadisaggregazione.contextpath}")
	private String authserviceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	//R1I_20_0131
	public ListaAnagraficaDisaggregazioneOutputDTO getAnagraficaDisaggregazione(String codiceOloAgcom, String tipoProfilo, String sezione) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		
		//R1I_20_0131		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceContextPath).path(codiceOloAgcom).path(tipoProfilo).path(sezione);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAnagraficaDisaggregazioneOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
