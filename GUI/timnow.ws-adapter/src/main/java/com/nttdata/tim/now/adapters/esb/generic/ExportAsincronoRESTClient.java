package com.nttdata.tim.now.adapters.esb.generic;

import java.net.URLEncoder;
import java.util.Date;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExportAsincronoRESTClient extends RestClientFacade {

	private static final String IDFILE_QUERYPARAMETER_NAME = "idFile";

	
	@Value("${rest.integration.async.export.contextpath}")
	private String exportDownloadContextPath;

	//RU_902
	public FileWrapperDTO download(String idFile, 
			String userId, 
			String tipoProfilo, 
			Integer numeroDatiEsportati, 
			String filtriDatiEsportati, 
			String vista, //SM_8904
			UserBean user) throws IntegrationLayerException {
		
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(exportDownloadContextPath).path("false").path(userId).path(tipoProfilo);
			if (idFile!=null){
			    webTarget = webTarget.queryParam(IDFILE_QUERYPARAMETER_NAME, URLEncoder.encode(idFile, "UTF-8").replaceAll("\\+","%20"));
				
			}
			//RU_902
			Date startRequest = new Date();
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();			
			Date endRequest = new Date();			
			FileWrapperDTO fileWrapperDto = response.readEntity(FileWrapperDTO.class);						
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.EXPORT, vista, fileWrapperDto, response);
			trackDto.setTimestampInizio(startRequest);
			trackDto.setTimestampFine(endRequest);
			trackDto.setTimestampInserimento(startRequest);
			trackDto.setNumeroDatiEsportati(numeroDatiEsportati);
			trackDto.setParametriOperazione(filtriDatiEsportati);
			trackAccessRestClient.trackAccess(trackDto);
			checkStatus(response);
			
			return fileWrapperDto;
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ESBResultDTO check(String idFile, String userId, String tipoProfilo) throws IntegrationLayerException {
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(exportDownloadContextPath).path("true").path(userId).path(tipoProfilo);
			if (idFile!=null){
			    webTarget = webTarget.queryParam(IDFILE_QUERYPARAMETER_NAME, URLEncoder.encode(idFile, "UTF-8").replaceAll("\\+","%20"));
			}
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(FileWrapperDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
