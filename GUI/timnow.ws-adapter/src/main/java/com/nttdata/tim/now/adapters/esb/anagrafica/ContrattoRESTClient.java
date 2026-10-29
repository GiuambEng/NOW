package com.nttdata.tim.now.adapters.esb.anagrafica;

import java.net.URLEncoder;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.anagraficaolo.AnagraficaCodiceOloOutputDTO;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.contratto.ListaContrattiOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.ModificaContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoInputDTO;
import com.nttdata.tim.now.data.dto.contratto.NuovoContrattoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoContrattiOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDatiContrattoOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoDettaglioContrattoOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.RecuperoFlagMulticastOutputDTO;
import com.nttdata.tim.now.data.dto.contratto.VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.esito.EsitoDTO;
import com.nttdata.tim.now.data.dto.file.FileMulticastToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContrattoRESTClient extends RestClientFacade {

	@Value("${rest.order.contract.contextpath}")
	private String serviceContextPath;
	
	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.CodiceOloNumerico.contextpath}")
	private String serviceContextPathCodiceOloNumerico;
	
	@Value("${rest.integration.contract_registry.contextpath}")
	private String registryServiceContextPath;

	@Value("${auth.rest.order.contract.contextpath}")
	private String authserviceContextPath;

	@Value("${auth.rest.integration.contract_registry.contextpath}")
	private String authregistryServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.create_contract.contextpath}")
	private String serviceNuovoContrattoContextPath;
		
	//RU_716 NUOVO CONTRATTO
	@Value("${auth.rest.order.contract.create_contract.contextpath}")
	private String authserviceNuovoContrattoContextPath;
		
	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.recupero_Dati_Contratto.contextpath}")
	private String serviceRecuperoDatiContrattoContextPath;
		
	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.recupero_Tipo_Contratti.contextpath}")
	private String serviceRecuperoTipoContrattiContextPath;
	
	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.recupero_Dettaglio_Contratto.contextpath}")
	private String serviceRecuperoDettaglioContrattoContextPath;
	
	//RU_716 NUOVO CONTRATTO
	@Value("${rest.order.contract.modify_contract.contextpath}")
	private String serviceModificaContrattoContextPath;
	
	//RU_1180
	@Value("${rest.integration.file.upload.multicast.contratto.contextpath}")
	private String serviceUploadFileMulticastContrattoContextPath;
	
	//RU_1180
	@Value("${rest.integration.file.download.esiti.contratto.contextpath}")
	private String serviceDownloadFileEsitiMulticastContrattoContextPath;
	
	//RU_1184
	@Value("${rest.controls.verifica_stato_contratto_abilitazione_disabilitazione.contextpath}")
	private String verificaStatoContrattoAbilitazioneDisabilitazioneContextPath;
	
	//SM_10433
	@Value("${rest.order.recupera_flag_multicast.contextpath}")
	private String recuperaFlagMulticastContextPath;
	
	//SM_11367
	@Value("${rest.controls.verifica_contratto_fwa_eolo.contextpath}")
	private String verificaContrattoFwaEoloContextPath;
	
	@Value("${auth.rest.controls.verifica_contratto_fwa_eolo.contextpath}")
	private String authVerificaContrattoFwaEoloContextPath;
	
	
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_IDFAMIGLIAOFFERTA = "idFamigliaOfferta";
	private static final String VALUE_QUERYPARAMETER_IDCONTRATTO = "idContratto";
	
	private static final String VALUE_QUERYPARAMETER_IDFILE = "idFile";
	private static final String VALUE_QUERYPARAMETER_FILENAME = "fileName";	
	
	//RU_1180
	private static final String VALUE_QUERYPARAMETER_FLAGMULTICAST = "flagMulticast";	
	
	//RU_1197
	private static final String VALUE_QUERYPARAMETER_TIPOSERVIZIO = "tipoServizio";
	
	//SM_10433
	private static final String VALUE_QUERYPARAMETER_IDOFFERTA = "idOfferta";
	private static final String VALUE_QUERYPARAMETER_CODOLOAGCOM = "codOloAgcom";
	
	
	public ListaContrattiOutputDTO getAllContracts(String codiceOlo, String tipoProfilo, String flagMulticast) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPath).path(codiceOlo);
		
		//RU_1180
		if(flagMulticast != null) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FLAGMULTICAST, flagMulticast);
		}
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaContrattiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaContrattiOutputDTO getContracts(String codOloAgicom, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authregistryServiceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authregistryServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(registryServiceContextPath).path(codOloAgicom)
				.path(tipoProfilo);
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaContrattiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ListaContrattiOutputDTO advancedSearch(AdvancedResearchInputDTO body, String codOloAgcom, String tipoProfilo, String userId)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authregistryServiceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authregistryServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck

		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(registryServiceContextPath).path(codOloAgcom)
				.path(tipoProfilo);
		if (userId!=null){
		    webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
					.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaContrattiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_716 NUOVO CONTRATTO
	public AnagraficaCodiceOloOutputDTO getCodiceNumericoOlo(String codiceAgcom) throws IntegrationLayerException{
		// endCheck
		//WebTarget webTarget = guiOrderRestClient.client.target("https://10.174.144.116:8180").path(serviceContextPathCodiceOloNumerico).path(codiceAgcom);
        WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceContextPathCodiceOloNumerico).path(codiceAgcom);
        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(AnagraficaCodiceOloOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }

		
	}
	
	//RU_716 NUOVO CONTRATTO
	public NuovoContrattoWrapperOutputDTO insert(NuovoContrattoInputDTO inputDto, String profilo) throws IntegrationLayerException {
		logger.info("Insert nuovo contratto rest client");
        //call method for check authorization services 
		if ((StringUtils.isNotEmpty(authserviceNuovoContrattoContextPath))&&(!isAuthorizedService(profilo, authserviceNuovoContrattoContextPath, checkAuthorizationContextPath))){
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
		}
	    // endCheck
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceNuovoContrattoContextPath);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(NuovoContrattoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_716 NUOVO CONTRATTO
	public RecuperoDatiContrattoOutputDTO recuperoDatiContratto(String idFamigliaOfferta) throws IntegrationLayerException {
		logger.info("Recupero dati contratto rest client");
//	       //call method for check authorization services 
//			if ((StringUtils.isNotEmpty(authserviceNuovoContrattoContextPath))&&(!isAuthorizedService(profilo, authserviceNuovoContrattoContextPath, checkAuthorizationContextPath))){
//				throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
//			}
	    // endCheck
		
		WebTarget webTarget;
		
		if(idFamigliaOfferta!=null)
			//webTarget = guiOrderRestClient.client.target("https://10.174.144.116:8180").path(serviceRecuperoDatiContrattoContextPath).queryParam(VALUE_QUERYPARAMETER_IDFAMIGLIAOFFERTA, idFamigliaOfferta);
			webTarget = guiOrderRestClient.getBaseTarget().path(serviceRecuperoDatiContrattoContextPath).queryParam(VALUE_QUERYPARAMETER_IDFAMIGLIAOFFERTA, idFamigliaOfferta);
		else
			//webTarget = guiOrderRestClient.client.target("https://10.174.144.116:8180").path(serviceRecuperoDatiContrattoContextPath);
			webTarget = guiOrderRestClient.getBaseTarget().path(serviceRecuperoDatiContrattoContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoDatiContrattoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	//RU_716 NUOVO CONTRATTO
	public RecuperoContrattiOutputDTO recuperoTipoContratti(String tipoServizio) throws IntegrationLayerException {
		logger.info("Recupero tipo contratti rest client");
//		       //call method for check authorization services 
//				if ((StringUtils.isNotEmpty(authserviceNuovoContrattoContextPath))&&(!isAuthorizedService(profilo, authserviceNuovoContrattoContextPath, checkAuthorizationContextPath))){
//					throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
//				}
	    // endCheck
		//RU_1197
		WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceRecuperoTipoContrattiContextPath).queryParam(VALUE_QUERYPARAMETER_TIPOSERVIZIO, tipoServizio);
		//WebTarget webTarget = guiOrderRestClient.client.target("https://10.172.65.252:8180").path(serviceRecuperoTipoContrattiContextPath).queryParam(VALUE_QUERYPARAMETER_TIPOSERVIZIO, tipoServizio);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoContrattiOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_716 NUOVO CONTRATTO
	public RecuperoDettaglioContrattoOutputDTO recuperoDettaglioContratto(String idContratto) throws IntegrationLayerException {
		logger.info("Recupero dettaglio contratto rest client");
//		       //call method for check authorization services 
//				if ((StringUtils.isNotEmpty(authserviceNuovoContrattoContextPath))&&(!isAuthorizedService(profilo, authserviceNuovoContrattoContextPath, checkAuthorizationContextPath))){
//					throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");  		
//				}
	    // endCheck
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceRecuperoDettaglioContrattoContextPath).queryParam(VALUE_QUERYPARAMETER_IDCONTRATTO, idContratto);
		//WebTarget webTarget = guiIntegrationClient.client.target("https://10.174.144.116:8181").path(serviceRecuperoDettaglioContrattoContextPath).queryParam(VALUE_QUERYPARAMETER_IDCONTRATTO, idContratto);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoDettaglioContrattoOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_716 NUOVO CONTRATTO
    public EsitoDTO modify(ModificaContrattoInputDTO inputDto, String profilo) throws IntegrationLayerException {
          logger.info("Modify contratto rest client");
//         //call method for check authorization services 
           if ((StringUtils.isNotEmpty(authserviceNuovoContrattoContextPath))&&(!isAuthorizedService(profilo, authserviceNuovoContrattoContextPath, checkAuthorizationContextPath))){
               throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");            
           }
        // endCheck
          WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceModificaContrattoContextPath);
          //WebTarget webTarget = guiOrderRestClient.client.target("https://10.174.144.116:8180").path(serviceModificaContrattoContextPath);
          try {
                 Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
                 checkStatus(response);
                 return response.readEntity(EsitoDTO.class);
          } catch (Exception e) {
                 throw new IntegrationLayerException(e);
          }
    }
    
	//RU_1164
    public EsitoDTO recuperaComuniCoinvestiti(ModificaContrattoInputDTO inputDto, String profilo) throws IntegrationLayerException {
          logger.info("Recupera Comuni coinvestiti rest client");
          WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(serviceModificaContrattoContextPath);
          try {
                 Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
                 checkStatus(response);
                 return response.readEntity(EsitoDTO.class);
          } catch (Exception e) {
                 throw new IntegrationLayerException(e);
          }
    }
    
    //RU_1180
	public ESBResultDTO uploadFileMulticast(FileMulticastToUploadDTO file) throws IntegrationLayerException {

		Response response = guiIntegrationClient.getBaseTarget().path(serviceUploadFileMulticastContrattoContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file multicast: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
	
	//RU_1180
	public FileWrapperDTO downloadFileEsitiMulticast(String idFile, String fileName, UserBean user) throws IntegrationLayerException {

		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(serviceDownloadFileEsitiMulticastContrattoContextPath);
		    
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDFILE, URLEncoder.encode(idFile, "UTF-8").replaceAll("\\+","%20"));			//RU_1133
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_FILENAME, fileName);
			
			Date startRequest = new Date();
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			Date endRequest = new Date();
			
			FileWrapperDTO fileWrapperDto = response.readEntity(FileWrapperDTO.class);						
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.DOWNLOAD, "Contratto", fileWrapperDto, response);
			trackDto.setTimestampInizio(startRequest);
			trackDto.setTimestampFine(endRequest);
			trackDto.setTimestampInserimento(startRequest);
			trackAccessRestClient.trackAccess(trackDto);
			checkStatus(response);
			
			return fileWrapperDto;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_1184
	public VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO verificaStatoContrattoAbilitazioneDisabilitazione(String idContratto, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaStatoContrattoAbilitazioneDisabilitazioneContextPath);

			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDCONTRATTO, idContratto);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(VerificaStatoContrattoAbilitazioneDisabilitazioneWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//SM_10433
	public RecuperoFlagMulticastOutputDTO recuperaFlagMulticast(String idOfferta, String codOloAgcom, String tipoProfilo)
			throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath)) && (!isAuthorizedService(tipoProfilo,
				authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		try {
			WebTarget webTarget = guiOrderRestClient.getBaseTarget().path(recuperaFlagMulticastContextPath);			
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDOFFERTA, idOfferta).queryParam(VALUE_QUERYPARAMETER_CODOLOAGCOM, codOloAgcom);

			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(RecuperoFlagMulticastOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//SM_11367
    public EsitoDTO verificaContrattoFwaEolo(String codOloAgcom, String profilo) throws IntegrationLayerException {
           if ((StringUtils.isNotEmpty(authVerificaContrattoFwaEoloContextPath))&&(!isAuthorizedService(profilo, authVerificaContrattoFwaEoloContextPath, checkAuthorizationContextPath))){
               throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");            
           }
        // endCheck
          WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaContrattoFwaEoloContextPath);
          try {
                 Response response = webTarget.queryParam(VALUE_QUERYPARAMETER_CODOLOAGCOM, codOloAgcom).request(MediaType.APPLICATION_JSON_TYPE).get();
                 checkStatus(response);
                 return response.readEntity(EsitoDTO.class);
          } catch (Exception e) {
                 throw new IntegrationLayerException(e);
          }
    }
}
