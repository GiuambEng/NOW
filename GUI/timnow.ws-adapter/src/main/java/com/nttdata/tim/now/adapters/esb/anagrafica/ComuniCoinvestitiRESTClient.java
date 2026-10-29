package com.nttdata.tim.now.adapters.esb.anagrafica;

import java.util.Date;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.utente.UserBean;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ComuniCoinvestimentoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ComuniCoinvestimentoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.DownloadFileEsitiComuniCoinvestimentoInputDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.FileComuniCoinvestimentoToUploadDTO;
import com.nttdata.tim.now.data.dto.anagraficacoinvestimento.ListaFileComuniCoinvestimentoWrapperOutputDTO;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.file.FileWrapperDTO;
import com.nttdata.tim.now.data.dto.ricerca.AdvancedResearchInputDTO;
import com.nttdata.tim.now.data.dto.track.TrackDTO;
import com.nttdata.tim.now.data.enumeration.TrackingEvent;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//RU_1164
@Component
public class ComuniCoinvestitiRESTClient extends RestClientFacade {
	
	@Value("${rest.anagrafica.comuni.coinvestiti.contextpath}")
	private String comuniCoinvestitiContextPath;
	
	@Value("${auth.rest.anagrafica.comuni.coinvestiti.contextpath}")
	private String authComuniCoinvestitiContextPath;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;
	
	//RU_1276
	@Value("${rest.anagrafica.lista.file.comuni.coinvestiti.contextpath}")
	private String listaFileComuniCoinvestitiContextPath;
	
	@Value("${auth.rest.anagrafica.lista.file.comuni.coinvestiti.contextpath}")
	private String authListaFileComuniCoinvestitiContextPath;
	
	@Value("${rest.anagrafica.caricamento.file.comuni.coinvestiti.contextpath}")
	private String caricamentoFileComuniCoinvestitiContextPath;
	
	@Value("${auth.rest.anagrafica.caricamento.file.comuni.coinvestiti.contextpath}")
	private String authCaricamentoFileComuniCoinvestitiContextPath;
	
	@Value("${rest.anagrafica.download.esiti.comuni.coinvestiti.contextpath}")
	private String downloadFileEsitiComuniCoinvestitiContextPath;
	
	@Value("${auth.rest.anagrafica.download.esiti.comuni.coinvestiti.contextpath}")
	private String authDownloadFileEsitiComuniCoinvestitiContextPath;
	
	//RU_1301
	@Value("${rest.anagrafica.file.comuni.coinvestiti.contextpath}")
	private String anagraficaFileComuniCoinvestitiContextPath;
	
	@Value("${auth.rest.anagrafica.file.comuni.coinvestiti.contextpath}")
	private String authAnagraficaFileComuniCoinvestitiContextPath;
		
	private final String ID_CONTRATTO = "idContratto";
	private final String COD_OLO_AGCOM = "codOloAgcom";
	
	//RU_1276
	public ComuniCoinvestimentoWrapperOutputDTO listaComuniCoinvestimento(ComuniCoinvestimentoInputDTO inputDto, String tipoProfilo) throws IntegrationLayerException {
		
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authComuniCoinvestitiContextPath))
				&& (!isAuthorizedService(tipoProfilo, authComuniCoinvestitiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(comuniCoinvestitiContextPath);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ComuniCoinvestimentoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_1276
	public ListaFileComuniCoinvestimentoWrapperOutputDTO listaFileComuniCoinvestimento(String codOloAgcom, String idContratto, String tipoProfilo) throws IntegrationLayerException {
		
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authListaFileComuniCoinvestitiContextPath))
				&& (!isAuthorizedService(tipoProfilo, authListaFileComuniCoinvestitiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(listaFileComuniCoinvestitiContextPath).queryParam(ID_CONTRATTO, idContratto).queryParam(COD_OLO_AGCOM, codOloAgcom);
		
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(ListaFileComuniCoinvestimentoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
	
	//RU_1276
	public ESBResultDTO uploadFileComuniCoinvestiti(FileComuniCoinvestimentoToUploadDTO file, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authCaricamentoFileComuniCoinvestitiContextPath))
				&& (!isAuthorizedService(tipoProfilo, authCaricamentoFileComuniCoinvestitiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		Response response = guiIntegrationClient.getBaseTarget().path(caricamentoFileComuniCoinvestitiContextPath).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(file, MediaType.APPLICATION_JSON_TYPE));		
		logger.debug("upload file comuni coinvestiti: response status = " + response.getStatus());
		checkStatus(response);
		ESBResultDTO res = response.readEntity(ESBResultDTO.class);
		logger.debug("post sent: " + res.getResult().getCode());
		return res;
	}
	
	//RU_1276
	public FileWrapperDTO downloadFileEsitiComuniCoinvestiti(DownloadFileEsitiComuniCoinvestimentoInputDTO inputDto, UserBean user) throws IntegrationLayerException {

		if ((StringUtils.isNotEmpty(authDownloadFileEsitiComuniCoinvestitiContextPath))
				&& (!isAuthorizedService(user.getCodiceProfilo(), authDownloadFileEsitiComuniCoinvestitiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(downloadFileEsitiComuniCoinvestitiContextPath);
		try {		
			
			Date startRequest = new Date();
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE));
			Date endRequest = new Date();
			
			FileWrapperDTO fileWrapperDto = response.readEntity(FileWrapperDTO.class);						
			TrackDTO trackDto = buildRequestTrackRestService(user, TrackingEvent.DOWNLOAD, "Esiti Comuni Coinvestimento", fileWrapperDto, response);
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
	
	//RU_1301
	public ListaFileComuniCoinvestimentoWrapperOutputDTO advancedSearch(AdvancedResearchInputDTO body, String userId, String tipoProfilo) throws IntegrationLayerException {
		if ((StringUtils.isNotEmpty(authAnagraficaFileComuniCoinvestitiContextPath))
				&& (!isAuthorizedService(tipoProfilo, authAnagraficaFileComuniCoinvestitiContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(anagraficaFileComuniCoinvestitiContextPath).queryParam("userId", userId).queryParam("tipoProfilo", tipoProfilo);
		
		try {
			body.setExportRequest(null);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ListaFileComuniCoinvestimentoWrapperOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
