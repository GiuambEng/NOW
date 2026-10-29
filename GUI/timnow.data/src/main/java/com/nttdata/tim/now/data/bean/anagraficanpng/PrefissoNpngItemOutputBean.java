package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class PrefissoNpngItemOutputBean implements Serializable {

	private static final long serialVersionUID = 3916885894498669024L;
	
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
