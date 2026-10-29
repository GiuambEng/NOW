package com.nttdata.tim.now.data.dto.anagraficacoinvestimento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1276
@JsonInclude(Include.NON_NULL)
public class DownloadFileEsitiComuniCoinvestimentoInputDTO implements Serializable {

	private static final long serialVersionUID = -7927272578416931017L;

	@JsonProperty("nomeFile")
    private String nomeFile;
	
    @JsonProperty("idFile")
    private String idFile;
    
    @JsonProperty("offerta")
    private String offerta;
    
    @JsonProperty("codOloAgcom")
    private String codOloAgcom;

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}
}
