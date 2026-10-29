package com.nttdata.tim.now.adapters.esb.ordine;

import java.net.URLEncoder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoEoloFwaOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.IndirizzoOutputDTO;
import com.nttdata.tim.now.data.dto.indirizzo.ListaCittaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.CodiceVlanEoloFwaInputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.ListaCodiceVlanEoloFwaOutputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.VerificaCoppiaIdVlanCvlanInputDTO;
import com.nttdata.tim.now.data.dto.ordine.eolo.VerificaCoppiaIdVlanCvlanOutputDTO;
import com.nttdata.tim.now.data.enumeration.AddressQuerystringParameterEnum;
import com.nttdata.tim.now.data.enumeration.ModesEnum;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1462
@Component
public class EoloFwaRESTClient extends RestClientFacade {

	@Value("${rest.order.visualizzazione_vlan_eolofwa.contextpath}")
	private String visualizzazioneVlanEoloFwaContextPath;
	
	@Value("${auth.rest.order.visualizzazione_vlan_eolofwa.contextpath}")
	private String authVisualizzazioneVlanEoloFwaContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.order.address_eolofwa.contextpath}")
    private String addressEoloFwaContextPath;
        
    @Value("${auth.rest.order.address_eolofwa.contextpath}")
    private String authAddressEoloFwaContextPath;
    
    @Value("${rest.controls.verifica_coppia_idvlan_cvlan.contextpath}")
    private String verificaCoppiaIdVlanCvlanContextPath;
    
    @Value("${auth.rest.controls.verifica_coppia_idvlan_cvlan.contextpath}")
    private String authVerificaCoppiaIdVlanCvlanContextPath;
	
	public ListaCodiceVlanEoloFwaOutputDTO getVlanEoloFwa(CodiceVlanEoloFwaInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVisualizzazioneVlanEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzazioneVlanEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(visualizzazioneVlanEoloFwaContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaCodiceVlanEoloFwaOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

    public IndirizzoOutputDTO getProvinces(String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath).path(ModesEnum.PROVINCIA.toString());
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
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath).path(ModesEnum.COMUNE.toString())
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
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath).path(ModesEnum.PARTICELLATOPONOMASTICA.toString())
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
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        WebTarget webTarget;
		try {
			webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath).path(ModesEnum.INDIRIZZO.toString())
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
    
    public IndirizzoEoloFwaOutputDTO getNumber(String selectedProvince, String selectedMunicipality, String selectedParticle, String selectedAddress,
            String autocompleteString, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {

            WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath).path(ModesEnum.CIVICO.toString())
                .queryParam(AddressQuerystringParameterEnum.provincia.toString(), selectedProvince)
                .queryParam(AddressQuerystringParameterEnum.comune.toString(), selectedMunicipality)
                .queryParam(AddressQuerystringParameterEnum.particellaToponomastica.toString(), selectedParticle)
                .queryParam(AddressQuerystringParameterEnum.indirizzo.toString(), URLEncoder.encode(selectedAddress, "UTF-8").replaceAll("\\+","%20"))
                .queryParam(AddressQuerystringParameterEnum.civico.toString(), autocompleteString);
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(IndirizzoEoloFwaOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ListaCittaOutputDTO getCities(String provincia, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authAddressEoloFwaContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAddressEoloFwaContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
        try {
            WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(addressEoloFwaContextPath);
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
	
    //C04M01F513 - Verifica coppia IDVLAN - CVLAN
	public VerificaCoppiaIdVlanCvlanOutputDTO verificaCoppiaIdVlanCvlan(VerificaCoppiaIdVlanCvlanInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authVerificaCoppiaIdVlanCvlanContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVerificaCoppiaIdVlanCvlanContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaCoppiaIdVlanCvlanContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(VerificaCoppiaIdVlanCvlanOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
