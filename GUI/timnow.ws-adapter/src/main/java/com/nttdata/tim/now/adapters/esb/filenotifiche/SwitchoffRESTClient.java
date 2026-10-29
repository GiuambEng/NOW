package com.nttdata.tim.now.adapters.esb.filenotifiche;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//SM_10805
@Component
public class SwitchoffRESTClient extends RestClientFacade {
	
	@Value("${rest.integration.file.upload.switchoff.contextpath}")
	private String uploadSwitchoffServiceContextPath;

	@Value("${auth.rest.integration.file.upload.switchoff.contextpath}")
	private String authUploadSwitchoffServiceContextPath;
		
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
		
	public ESBResultDTO upload(FileToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authUploadSwitchoffServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authUploadSwitchoffServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		Response response = guiIntegrationClient.getBaseTarget().path(uploadSwitchoffServiceContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file switchoff: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
}
