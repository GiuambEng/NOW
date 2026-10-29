package com.nttdata.tim.now.adapters.esb.filenotifiche;

import java.net.URLEncoder;
import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileMulticastToUploadDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.notifica.FileMulticastWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.VerificaContrattoMulticastWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1180
@Component
public class MulticastRESTClient extends RestClientFacade {

	@Value("${rest.integration.multicast.visualizza.file.contextpath}")
	private String visualizzaFileMulticastiServiceContextPath;
	
	@Value("${auth.rest.integration.multicast.visualizza.file.contextpath}")
	private String authVisualizzaFileMulticastiServiceContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	@Value("${rest.controls.verifica_contratto_multicast.contextpath}")
	private String verificaContrattoMulticastContextPath;
	
	@Value("${rest.integration.multicast.upload.file.contextpath}")
	private String uploadFileMulticastContextPath;
	
	@Value("${auth.rest.integration.multicast.upload.file.contextpath}")
	private String authUploadFileMulticastiServiceContextPath;
	
	@Value("${rest.integration.multicast.download.esiti.sedi.olt.contextpath}")
	private String downloadEsitiSediOltMulticastContextPath;
	
	@Value("${rest.integration.multicast.download.esiti.feeder.attivi.contextpath}")
	private String downloadEsitiFeederAttiviMulticastContextPath;
	
	@Value("${rest.integration.multicast.download.esiti.canali.contextpath}")
	private String downloadEsitiCanaliMulticastContextPath;
	
	private static final String COD_OLO_AGCOM_PARAM = "codOloAgcom";
	private static final String TIPO_PROFILO_PARAM = "tipoProfilo";
	
	private static final String ESITI_SEDI_OLT_PARAM = "ID349";
	private static final String ESITI_CANALI_FEEDER_PARAM = "ID350";
	private static final String ESITI_CANALI_SEDI_OLT_PARAM = "ID351";
	
	private static final String IDFILE_PARAM = "idFile";
	private static final String FILENAME_PARAM = "fileName";	
		
	public ESBResultDTO uploadFileMulticast(FileMulticastToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authUploadFileMulticastiServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authUploadFileMulticastiServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		Response response = guiIntegrationClient.getBaseTarget().path(uploadFileMulticastContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file multicast: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
	
	public FileMulticastWrapperOutputDTO getAllMulticastFiles(String codOloAgcom, String tipoProfilo) throws IntegrationLayerException {
		/*if ((StringUtils.isNotEmpty(authVisualizzaFileMulticastiServiceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authVisualizzaFileMulticastiServiceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}*/
		try {
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(visualizzaFileMulticastiServiceContextPath).queryParam(COD_OLO_AGCOM_PARAM, codOloAgcom).queryParam(TIPO_PROFILO_PARAM, tipoProfilo);
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(FileMulticastWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	public VerificaContrattoMulticastWrapperOutputDTO verificaContrattoMulticast(String codOloAgcom) throws IntegrationLayerException {

		try {
			WebTarget webTarget = guiControlsRestClient.getBaseTarget().path(verificaContrattoMulticastContextPath).queryParam(COD_OLO_AGCOM_PARAM, codOloAgcom);
			return webTarget.request(MediaType.APPLICATION_JSON_TYPE).get(VerificaContrattoMulticastWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public FileWrapperDTO downloadFileEsitiMulticast(String idFile, String fileName, String interfaccia, UserBean user) throws IntegrationLayerException {

		WebTarget webTarget = null;
		try {		
			switch(interfaccia) {
				case ESITI_SEDI_OLT_PARAM:
					webTarget = guiIntegrationClient.getBaseTarget().path(downloadEsitiSediOltMulticastContextPath);
					break;
				case ESITI_CANALI_FEEDER_PARAM:
					webTarget = guiIntegrationClient.getBaseTarget().path(downloadEsitiFeederAttiviMulticastContextPath);
					break;
				case ESITI_CANALI_SEDI_OLT_PARAM:
					webTarget = guiIntegrationClient.getBaseTarget().path(downloadEsitiCanaliMulticastContextPath);
					break;
			}
					    
			webTarget = webTarget.queryParam(IDFILE_PARAM, URLEncoder.encode(idFile, "UTF-8").replaceAll("\\+","%20"));
			webTarget = webTarget.queryParam(FILENAME_PARAM, fileName);
			
			Date startRequest = new Date();
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			Date endRequest = new Date();
			
			FileWrapperDTO fileWrapperDto = response.readEntity(FileWrapperDTO.class);						
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.DOWNLOAD, "Esiti Multicast", fileWrapperDto, response);
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
