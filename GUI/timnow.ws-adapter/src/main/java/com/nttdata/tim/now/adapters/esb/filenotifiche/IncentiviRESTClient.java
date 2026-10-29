package com.nttdata.tim.now.adapters.esb.filenotifiche;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileIncentiviOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.FileIncentiviWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1127
@Component
public class IncentiviRESTClient extends RestClientFacade {

	
	@Value("${rest.integration.file.upload.incentivi.contextpath}")
	private String uploadIncentiviServiceContextPath;

	@Value("${auth.rest.integration.file.upload.incentivi.contextpath}")
	private String authUploadIncentiviServiceContextPath;

	@Value("${rest.integration.visualizza.file.incentivi.contextpath}")
	private String visualizzaIncentiviServiceContextPath;
	
	@Value("${auth.rest.integration.visualizza.file.incentivi.contextpath}")
	private String authVisualizzaIncentiviServiceContextPath;
		
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	//RU_1312
	@Value("${rest.integration.dettaglio.file.incentivi.contextpath}")
	private String dettaglioFileIncentiviServiceContextPath;
	
	@Value("${auth.rest.integration.dettaglio.file.incentivi.contextpath}")
	private String authDettaglioFileIncentiviServiceContextPath;
	
	//SM_10035
	private static final String COD_OLO_AGCOM_PARAM = "codOloAgcom";
	private static final String TIPO_PROFILO_PARAM = "tipoProfilo";
	//RU_1312
	private static final String ID_FILE_PARAM = "idFile";
	private static final String TIPOLOGIA_FILE_PARAM = "tipologiaFile";
		
	public ESBResultDTO upload(FileToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authUploadIncentiviServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authUploadIncentiviServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		Response response = guiIntegrationClient.getBaseTarget().path(uploadIncentiviServiceContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file incentivi: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
	
	public FileIncentiviWrapperOutputDTO advancedResearch(AdvancedResearchInputDTO inputDto, String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authVisualizzaIncentiviServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzaIncentiviServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			//#Task #34277
			inputDto.setExportRequest(null);
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(visualizzaIncentiviServiceContextPath).queryParam(COD_OLO_AGCOM_PARAM, codOloAgcom).queryParam(TIPO_PROFILO_PARAM, tipoProfilo);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(FileIncentiviWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public FileIncentiviWrapperOutputDTO getAllDecommissioningFiles(String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authVisualizzaIncentiviServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzaIncentiviServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(visualizzaIncentiviServiceContextPath).queryParam(COD_OLO_AGCOM_PARAM, codOloAgcom).queryParam(TIPO_PROFILO_PARAM, tipoProfilo);
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(FileIncentiviWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_1312
	public DettaglioFileIncentiviOutputDTO getDecommissioningFileDetails(String idFile, String tipologiaFile, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authDettaglioFileIncentiviServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authDettaglioFileIncentiviServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(dettaglioFileIncentiviServiceContextPath).queryParam(ID_FILE_PARAM, idFile).queryParam(TIPOLOGIA_FILE_PARAM, tipologiaFile);
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(DettaglioFileIncentiviOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
