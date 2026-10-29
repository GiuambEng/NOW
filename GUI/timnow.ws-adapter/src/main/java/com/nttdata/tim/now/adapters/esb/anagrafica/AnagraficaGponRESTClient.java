package com.nttdata.tim.now.adapters.esb.anagrafica;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.anagraficagpon.ListaAnagraficaGponOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficagpon.ListaStoricoSplittingGponOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1308
@Component
public class AnagraficaGponRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.integration.gpon.lista.contextpath}")
	private String listaAnagraficaGponContextPath;	
	
	@Value("${auth.rest.integration.gpon.lista.contextpath}")
	private String authListaAnagraficaGponContextPath;
	
	//RU_1338
	@Value("${rest.integration.gpon.storico_splitting.contextpath}")
	private String storicoSplittingGponContextPath;	
	
	@Value("${auth.rest.integration.gpon.storico_splitting.contextpath}")
	private String authStoricoSplittingGponContextPath;	
	
	private static final String ID_GPON_PARAM = "idGpon"; 
	
	public ListaAnagraficaGponOutputDTO getList(String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authStoricoSplittingGponContextPath))
				&& (!isAuthorizedService(tipoProfilo, authStoricoSplittingGponContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listaAnagraficaGponContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaAnagraficaGponOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_1338
	public ListaStoricoSplittingGponOutputDTO getStoricoSplitting(String idGpon, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authListaAnagraficaGponContextPath))
				&& (!isAuthorizedService(tipoProfilo, authListaAnagraficaGponContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(storicoSplittingGponContextPath).queryParam(ID_GPON_PARAM, idGpon);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaStoricoSplittingGponOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
