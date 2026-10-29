package com.nttdata.tim.now.adapters.esb.monitoraggio;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.dto.monitoring.usertask.ModUserTaskCausaliInputDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.ModUserTaskCausaliOutputDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.UserTaskListaCausaliDTO;
import com.nttdata.tim.now.data.dto.monitoring.usertask.UserTaskOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MonitoraggioUserTaskRESTClient extends RestClientFacade {

	private static final String VALUE_QUERYPARAMETER_USER_TASK = "tipoUserTask";

	@Value("${rest.pps.monitoring.user.task.contextpath}")
	private String serviceContextPath;

	@Value("${rest.pps.monitoring.user.task.listacausali.contextpath}")
	private String serviceContextPathListaCausali;

	@Value("${rest.pps.monitoring.user.task.complete.contextpath}")
	private String serviceContextPathComplete;

	@Value("${auth.rest.pps.monitoring.user.task.contextpath}")
	private String authserviceContextPath;
	
	@Value("${auth.rest.pps.monitoring.user.task.listacausali.contextpath}")
	private String authserviceContextPathListaCausali;
	
	@Value("${auth.rest.pps.monitoring.user.task.complete.contextpath}")
	private String authserviceContextPathComplete;
	
	@Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	public UserTaskOutputDTO getUserTask(String tipoUserTask, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPath))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPath, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPath);
		if (tipoUserTask != null && !tipoUserTask.isEmpty()) {
			webTarget = webTarget.queryParam(VALUE_QUERYPARAMETER_USER_TASK, tipoUserTask);
		}
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(UserTaskOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public ModUserTaskCausaliOutputDTO userTaskCausali(ModUserTaskCausaliInputDTO inputDTO, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPathComplete))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPathComplete, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPathComplete);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(inputDTO, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ModUserTaskCausaliOutputDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

	public UserTaskListaCausaliDTO getListaCausali(String idWorkItem, String idRichiestaOlo, String tipoProfilo) throws IntegrationLayerException {
		// call method for check authorization services
		if ((StringUtils.isNotEmpty(authserviceContextPathListaCausali))
				&& (!isAuthorizedService(tipoProfilo, authserviceContextPathListaCausali, checkAuthorizationContextPath))) {
			throw new IntegrationLayerException("Utente non abilitato alla fruizione di questo servizio");
		}
		// endCheck
		WebTarget webTarget = guiPpsRestClient.getBaseTarget().path(serviceContextPathListaCausali).path(idWorkItem).path(idRichiestaOlo);
		try {
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
			checkStatus(response);
			return response.readEntity(UserTaskListaCausaliDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}
}
