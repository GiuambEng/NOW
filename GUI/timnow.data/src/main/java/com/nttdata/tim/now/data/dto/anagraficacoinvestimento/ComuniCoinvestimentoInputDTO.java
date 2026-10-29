package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class ComuniCoinvestimentoInputDTO implements Serializable {

	private static final long serialVersionUID = 389692801174367932L;

	@JsonProperty("idContratto")
    private String idContratto;
	
    @JsonProperty("exportRequest")
    private String exportRequest;
    
    @JsonProperty("fileType")
    private String fileType;
    
    @JsonProperty("tipoProfilo")
    private String tipoProfilo;
    
    @JsonProperty("userId")
    private String userId;

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getExportRequest() {
		return exportRequest;
	}

	public void setExportRequest(String exportRequest) {
		this.exportRequest = exportRequest;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getTipoProfilo() {
		return tipoProfilo;
	}

	public void setTipoProfilo(String tipoProfilo) {
		this.tipoProfilo = tipoProfilo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
