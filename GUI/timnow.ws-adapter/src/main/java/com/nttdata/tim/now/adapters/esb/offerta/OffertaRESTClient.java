package com.nttdata.tim.now.adapters.esb.offerta;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.offerta.DettaglioOffertaWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.offerta.DisambiguazioneOffertaListDTO;
import com.nttdata.tim.now.data.dto.offerta.ListaOfferteOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OffertaRESTClient extends RestClientFacade {

	private static final String ID_OFFERTA = "idOfferta";
	private static final String VALUE_QUERYPARAMETER_LAVORAZIONE = "lavorazione";
	private static final String VALUE_QUERYPARAMETER_FLAGMULTICAST = "flagMulticast";

	@Value("${rest.order.offer.detail.contextpath}")
	private String serviceContextPath;

	@Value("${rest.order.offer.list.contextpath}")
	private String listServiceContextPath;

	@Value("${rest.integration.offers.disamb.contextpath}")
	private String disambiguationListServiceContextPath;

	@Value("${auth.rest.order.offer.detail.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.order.offer.list.contextpath}")
	private String authlistServiceContextPath;
	
	@Value("${auth.rest.integration.offers.disamb.contextpath}")
	private String authdisambiguationListServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public DettaglioOffertaWrapperOutputDTO getOffer(String idOfferta, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).queryParam(ID_OFFERTA, idOfferta);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DettaglioOffertaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaOfferteOutputDTO getOffers(String contratto, String azione, String tipoProfilo, String flagMulticast) throws IntegrationLayerException {

		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authlistServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authlistServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(listServiceContextPath).path(contratto);
		if (StringUtils.isNotEmpty(azione)){
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_LAVORAZIONE,azione.toUpperCase());	
		}
		
		//RU_1180
		if(flagMulticast != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAGMULTICAST, flagMulticast);
		}
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaOfferteOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public DisambiguazioneOffertaListDTO getOffersDisamb(String tplgLavrz, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdisambiguationListServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdisambiguationListServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(disambiguationListServiceContextPath).path(tplgLavrz);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(DisambiguazioneOffertaListDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
