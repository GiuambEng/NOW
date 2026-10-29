package com.nttdata.tim.now.data.dto.anagraficanpng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class PrefissoNpngItemOutputDTO implements Serializable {

	private static final long serialVersionUID = 415314790402300523L;

	@JsonProperty("idPrefisso")
	private String idPrefisso;
    
    @JsonProperty("prefisso")
	private String prefisso;

	public String getIdPrefisso() {
		return idPrefisso;
	}

	public void setIdPrefisso(String idPrefisso) {
		this.idPrefisso = idPrefisso;
	}

	public String getPrefisso() {
		return prefisso;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}
}
