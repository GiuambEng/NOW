package com.nttdata.tim.now.adapters.esb.generic;

import java.net.URLEncoder;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRESTClient extends RestClientFacade {

	@Value("${rest.integration.file.upload.contextpath}")
	private String uploadServiceContextPath;

	@Value("${rest.integration.file.download.contextpath}")
	private String downloadServiceContextPath;

	@Value("${auth.rest.integration.file.upload.contextpath}")
	private String authuploadServiceContextPath;
	
	@Value("${auth.rest.integration.file.download.contextpath}")
	private String authdownloadServiceContextPath;

	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	private static final String VALUE_QUERYPARAMETER_IDFILE = "idFile";
	private static final String VALUE_QUERYPARAMETER_USERID = "userId";
	private static final String VALUE_QUERYPARAMETER_CODICEPROFILO = "tipoProfilo";
	//RU_1133
	private static final String VALUE_QUERYPARAMETER_IP = "ip";
	
	public ESBResultDTO upload(FileToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authuploadServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authuploadServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		Response response = guiIntegrationClient.getBaseTarget().path(uploadServiceContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));
		logger.debug("upload file: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}

	public FileWrapperDTO download(String idFile, String tipoProfilo, String userId, String vista, UserBean user) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authdownloadServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authdownloadServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		//logger.debug("RESTClient call download service#############################");
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(downloadServiceContextPath);
		    
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IDFILE, URLEncoder.encode(idFile, "UTF-8").replaceAll("\\+","%20"));
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USERID, userId);
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_CODICEPROFILO, tipoProfilo);	
			//RU_1133
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_IP, user.getRequestInfo().getIpClient());
			
			//RU_902
			Date startRequest = new Date();
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			Date endRequest = new Date();
			
			FileWrapperDTO fileWrapperDto = response.readEntity(FileWrapperDTO.class);						
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.DOWNLOAD, vista, fileWrapperDto, response);
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
}
