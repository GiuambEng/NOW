package com.nttdata.tim.now.adapters.esb.filenotifiche;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nttdata.tim.now.adapters.rest.RestClientFacade;
import com.nttdata.tim.now.data.bean.notifica.StatoFileMigrazioneUllSluBean;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;
import com.nttdata.tim.now.data.dto.base.ResultDTO;
import com.nttdata.tim.now.data.dto.file.InputUploadULLSLUDTO;
import com.nttdata.tim.now.data.dto.notifica.CheckFileULLSLUInputDTO;
import com.nttdata.tim.now.data.dto.notifica.DettaglioFileULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.DeleteULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUInputDTO;
import com.nttdata.tim.now.data.dto.notifica.LavorazioneULLSLUOutputDTO;
import com.nttdata.tim.now.data.dto.notifica.StatoUploadULLSLUOutputDTO;
import com.nttdata.tim.now.data.exception.IntegrationLayerException;
import com.nttdata.tim.now.data.enumeration.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MigrazioneUllSluRESTClient extends RestClientFacade {

    @Value("${rest.integration.check.authorization.contextpath}")
	private String checkAuthorizationContextPath;

	@Value("${rest.client.migrazione.ullslu.upload.contextpath:uploadULLSLU}")
	private String uploadULLSLUContextPath;

	@Value("${rest.client.migrazione.ullslu.status.contextpath:statouploadullslu}")
	private String statusULLSLUContextPath;

	@Value("${rest.client.migrazione.ullslu.delete.contextpath:deleteullslu}")
	private String deleteULLSLUContextPath;

    @Value("${rest.client.migrazione.ullslu.check.contextpath:checkfileullslu}")
    private String checkULLSLUContextPath;

    @Value("${rest.client.migrazione.ullslu.dettaglio.contextpath:dettagliofileullslu}")
    private String dettaglioULLSLUContextPath;

    @Value("${rest.client.migrazione.ullslu.avvia.lavorazione.contextpath:avvialavorazioneullslu}")
    private String avviaLavorazioneULLSLUContextPath;
    
    @Value("${auth.rest.client.migrazione.ullslu.upload.contextpath:uploadULLSLU}")
    private String authUploadULLSLUContextPath;

    @Value("${auth.rest.client.migrazione.ullslu.status.contextpath:Gestione File Migrazione ULL SLU}")
    private String authStatusULLSLUContextPath;

    @Value("${auth.rest.client.migrazione.ullslu.delete.contextpath:Gestione File Migrazione ULL SLU}")
    private String authDeleteULLSLUContextPath;

    @Value("${auth.rest.client.migrazione.ullslu.check.contextpath:Gestione File Migrazione ULL SLU}")
    private String authCheckULLSLUContextPath;

    @Value("${auth.rest.client.migrazione.ullslu.dettaglio.contextpath:Gestione File Migrazione ULL SLU}")
    private String authDettaglioULLSLUContextPath;

    @Value("${auth.rest.client.migrazione.ullslu.avvia.lavorazione.contextpath:Gestione File Migrazione ULL SLU}")
    private String authAvviaLavorazioneULLSLUContextPath;

    public boolean isFileAlreadyUploaded(String fileName, String tipoProfilo) throws IntegrationLayerException {
        for (StatoFileMigrazioneUllSluBean file : getUploadedFiles(null, tipoProfilo)) {
            if (fileName != null && file.getNomeFile() != null && file.getNomeFile().equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }

	public ESBResultDTO uploadFile(InputUploadULLSLUDTO input, String tipoProfilo) throws IntegrationLayerException {
		try {
            checkAuthorizationService(authUploadULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
			WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(uploadULLSLUContextPath);
			Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
			checkStatus(response);
			return response.readEntity(ESBResultDTO.class);
		} catch (Exception e) {
			throw new IntegrationLayerException(e);
		}
	}

    public List<StatoFileMigrazioneUllSluBean> getUploadedFiles(String mesi, String tipoProfilo) throws IntegrationLayerException {
        try {
            checkAuthorizationService(authStatusULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
            WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(statusULLSLUContextPath);
            if (hasText(mesi)) {
                webTarget = webTarget.queryParam("mesi", mesi);
            }
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            StatoUploadULLSLUOutputDTO output = response.readEntity(StatoUploadULLSLUOutputDTO.class);
            checkResult(output == null ? null : output.getResult());
            if (output == null || output.getListacampi() == null) {
                return Collections.emptyList();
            }
            return output.getListacampi();
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public DettaglioFileULLSLUOutputDTO getDettaglioFile(String nomeFile, String idFile, String tipoProfilo) throws IntegrationLayerException {
        try {
            checkAuthorizationService(authDettaglioULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
            WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(dettaglioULLSLUContextPath);
            if (hasText(nomeFile)) {
                webTarget = webTarget.queryParam("nomeFile", nomeFile);
            }
            if (hasText(idFile)) {
                webTarget = webTarget.queryParam("idFile", idFile);
            }
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).get();
            checkStatus(response);
            return response.readEntity(DettaglioFileULLSLUOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public ESBResultDTO checkFile(String nomeFile, String tipoProfilo) throws IntegrationLayerException {
        try {
            checkAuthorizationService(authCheckULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
            CheckFileULLSLUInputDTO input = new CheckFileULLSLUInputDTO();
            input.setNomeFile(nomeFile);
            WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(checkULLSLUContextPath);
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(ESBResultDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public void deleteFile(String nomeFile, String tipoProfilo) throws IntegrationLayerException {
        try {
            checkAuthorizationService(authDeleteULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
            WebTarget webTarget = guiIntegrationClient.getBaseTarget()
                    .path(deleteULLSLUContextPath)
                    .queryParam("nome", nomeFile);
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
            checkStatus(response);
            DeleteULLSLUOutputDTO output = response.readEntity(DeleteULLSLUOutputDTO.class);
            checkResult(output == null ? null : output.getResult());
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    public LavorazioneULLSLUOutputDTO startProcessing(String nomeFile, String tipoProfilo) throws IntegrationLayerException {
        try {
            checkAuthorizationService(authAvviaLavorazioneULLSLUContextPath, checkAuthorizationContextPath, tipoProfilo);
            LavorazioneULLSLUInputDTO input = new LavorazioneULLSLUInputDTO();
            input.setNomeFile(nomeFile);
            WebTarget webTarget = guiIntegrationClient.getBaseTarget().path(avviaLavorazioneULLSLUContextPath);
            Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.entity(input, MediaType.APPLICATION_JSON_TYPE));
            checkStatus(response);
            return response.readEntity(LavorazioneULLSLUOutputDTO.class);
        } catch (Exception e) {
            throw new IntegrationLayerException(e);
        }
    }

    private boolean hasText(String value) {
        return value != null && value.trim().length() > 0;
    }

    private void checkResult(ResultDTO result) throws IntegrationLayerException {
        if (result != null && result.getCode() != null && 
            !(ResultCodeEnum.OK.getMessage().equalsIgnoreCase(result.getCode()) || ResultCodeEnum.OK.getCode().equalsIgnoreCase(result.getCode()))
        ) {
            throw new IntegrationLayerException(result.getDetails());
        }
    }

}