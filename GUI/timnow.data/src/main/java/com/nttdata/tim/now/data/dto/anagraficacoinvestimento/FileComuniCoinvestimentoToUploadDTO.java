package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class FileComuniCoinvestimentoToUploadDTO implements Serializable {

	private static final long serialVersionUID = -2371933163549812475L;

	@JsonProperty("nomeFile")
	private String nomeFile;

	@JsonProperty("contenutoFile")
	private byte[] contenutoFile;
	
	@JsonProperty("idContratto")
	private String idContratto;
	
	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public byte[] getContenutoFile() {
		return contenutoFile;
	}

	public void setContenutoFile(byte[] contenutoFile) {
		this.contenutoFile = contenutoFile;
	}

	public String getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(String idContratto) {
		this.idContratto = idContratto;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}
}
