package com.nttdata.tim.now.adapters.esb.filenotifiche;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.dto.notifica.FileFwaWrapperOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1335
@Component
public class FileFwaRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.file.upload.fwa.contextpath}")
	private String uploadFileFwaServiceContextPath;

	@Value("${auth.rest.integration.file.upload.fwa.contextpath}")
	private String authUploadFileFwaServiceContextPath;

	@Value("${rest.integration.visualizza.file.fwa.contextpath}")
	private String visualizzaFileFwaServiceContextPath;
	
	@Value("${auth.rest.integration.visualizza.file.fwa.contextpath}")
	private String authVisualizzaFileFwaServiceContextPath;
		
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
			
	public ESBResultDTO upload(FileToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authUploadFileFwaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authUploadFileFwaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		Response response = guiIntegrationClient.getBaseTarget().path(uploadFileFwaServiceContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file FWA: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
	
	public FileFwaWrapperOutputDTO getAllFwaFiles(String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authVisualizzaFileFwaServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzaFileFwaServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(visualizzaFileFwaServiceContextPath);
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(FileFwaWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

}
