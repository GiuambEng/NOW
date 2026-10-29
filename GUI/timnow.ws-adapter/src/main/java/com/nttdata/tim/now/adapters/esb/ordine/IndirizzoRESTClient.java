package com.nttdata.tim.now.adapters.esb.ordine;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.ListaCittaOutputDTO;
import com.nttdata.tim.now.data.enumeration.AddressQuerystringParameterEnum;
import com.nttdata.tim.now.data.enumeration.ModesEnum;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IndirizzoRESTClient extends RestClientFacade {
    
    @Value("${rest.order.province.contextpath}")
    private String serviceContextPath;
    
    @Value("${rest.order.city.contextpath}")
    private String cityServiceContextPath;

    @Value("${auth.rest.order.province.contextpath}")
    private String authserviceContextPath;
    
    @Value("${auth.rest.order.city.contextpath}")
    private String authcityServiceContextPath;
    
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	//RU_716
	@Value("${rest.order.controllorecuperadistretto.contextpath}")
    private String distrettocContextPath;
	
	private final String CIVICO = "civico";
	private final String INDIRIZZO = "indirizzo";
	private final String TOPONOMASTICA = "toponomastica";
	private final String COMUNE = "comune";
	private final String PROVINCIA = "provincia";
	private final String LAVORAZIONE = "lavorazione";

    public IndirizzoOutputDTO getProvinces(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(ModesEnum.PROVINCIA.toString());
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public IndirizzoOutputDTO getMunicipalities(String selectedProvince, String autocompleteString, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(ModesEnum.COMUNE.toString())
                .queryParam(AddressQuerystringParameterEnum.provincia.toString(), selectedProvince)
                .queryParam(AddressQuerystringParameterEnum.comune.toString(), autocompleteString);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public IndirizzoOutputDTO getAddressParticle(String selectedProvince, String selectedMunicipality, String autocompleteString, String tipoProfilo)
            throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(ModesEnum.PARTICELLATOPONOMASTICA.toString())
                .queryParam(AddressQuerystringParameterEnum.provincia.toString(), selectedProvince)
                .queryParam(AddressQuerystringParameterEnum.comune.toString(), selectedMunicipality)
                .queryParam(AddressQuerystringParameterEnum.particellaToponomastica.toString(), autocompleteString);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public IndirizzoOutputDTO getAddresses(String selectedProvince, String selectedMunicipality, String selectedParticle, String autocompleteString, String tipoProfilo)
            throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget;
		try {
			webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(ModesEnum.INDIRIZZO.toString())
			        .queryParam(AddressQuerystringParameterEnum.provincia.toString(), selectedProvince)
			        .queryParam(AddressQuerystringParameterEnum.comune.toString(), selectedMunicipality)
			        .queryParam(AddressQuerystringParameterEnum.particellaToponomastica.toString(), selectedParticle)
			        .queryParam(AddressQuerystringParameterEnum.indirizzo.toString(), URLEncoder.encode(autocompleteString, "UTF-8").replaceAll("\\+","%20"));

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public IndirizzoOutputDTO getNumber(String selectedProvince, String selectedMunicipality, String selectedParticle, String selectedAddress,
            String autocompleteString, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {

            WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(ModesEnum.CIVICO.toString())
                .queryParam(AddressQuerystringParameterEnum.provincia.toString(), selectedProvince)
                .queryParam(AddressQuerystringParameterEnum.comune.toString(), selectedMunicipality)
                .queryParam(AddressQuerystringParameterEnum.particellaToponomastica.toString(), selectedParticle)
                .queryParam(AddressQuerystringParameterEnum.indirizzo.toString(), URLEncoder.encode(selectedAddress, "UTF-8").replaceAll("\\+","%20"))
                .queryParam(AddressQuerystringParameterEnum.civico.toString(), autocompleteString);
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ListaCittaOutputDTO getCities(String provincia, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authcityServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authcityServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {
            WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(cityServiceContextPath);
        	if (StringUtils.isNotBlank(provincia)) {
            	webTarget = webTarget.queryParam("codProvincia", provincia);
            }
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(ListaCittaOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }
    
    //RU_716
    public EsitoDTO controlloRecuperaDistretto (String provincia, String comune, String toponomastica, String indirizzo, String civico, String lavorazione)
			throws IntegrationLayerException, UnsupportedEncodingException {

		WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(distrettocContextPath)
								.queryParam(PROVINCIA, provincia)
								.queryParam(COMUNE, comune)
								.queryParam(TOPONOMASTICA, toponomastica)
								.queryParam(INDIRIZZO, URLEncoder.encode(indirizzo, "UTF-8").replaceAll("\\+","%20"))
								.queryParam(CIVICO, civico)
								.queryParam(LAVORAZIONE, lavorazione);

		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(EsitoDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
