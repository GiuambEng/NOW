package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.gestioneautonoma.ListaAssociazioneOaoImpresaAreaOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1393
@Component
public class GestioneAutonomaRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.integration.gestioneautonoma.anagraficafcsemigpon.lista.contextpath}")
	private String listaAnagraficafcsemigponContextPath;	
	
	@Value("${auth.rest.integration.gestioneautonoma.anagraficafcsemigpon.lista.contextpath}")
	private String authListaAnagraficafcsemigponContextPath;
	
	private final String COD_OLO_AGCOM_QUERY_PARAM = "codOloAgcom";
	private final String TIPO_PROFILO_QUERY_PARAM = "tipoProfilo";
	
	public ListaAssociazioneOaoImpresaAreaOutputDTO getList(String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authListaAnagraficafcsemigponContextPath))
				&& (!isAuthorizedService(tipoProfilo, authListaAnagraficafcsemigponContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget()
								.path(listaAnagraficafcsemigponContextPath)
								.queryParam(COD_OLO_AGCOM_QUERY_PARAM, codOloAgcom)
								.queryParam(TIPO_PROFILO_QUERY_PARAM, tipoProfilo);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAssociazioneOaoImpresaAreaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
