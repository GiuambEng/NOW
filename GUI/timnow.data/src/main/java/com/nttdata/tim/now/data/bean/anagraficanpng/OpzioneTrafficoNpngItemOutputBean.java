package com.nttdata.tim.now.data.bean.anagraficanpng;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1203
public class OpzioneTrafficoNpngItemOutputBean implements Serializable {

	private static final long serialVersionUID = -7040660989816504890L;
	
    @JsonProperty("idOpzTraffico")
	private String idOpzTraffico;
    
    @JsonProperty("descrizioneOpzTraffico")
	private String descrizioneOpzTraffico;
    
    @JsonProperty("opzTraffico")
	private String opzTraffico;

	public String getIdOpzTraffico() {
		return idOpzTraffico;
	}

	public void setIdOpzTraffico(String idOpzTraffico) {
		this.idOpzTraffico = idOpzTraffico;
	}

	public String getDescrizioneOpzTraffico() {
		return descrizioneOpzTraffico;
	}

	public void setDescrizioneOpzTraffico(String descrizioneOpzTraffico) {
		this.descrizioneOpzTraffico = descrizioneOpzTraffico;
	}

	public String getOpzTraffico() {
		return opzTraffico;
	}

	public void setOpzTraffico(String opzTraffico) {
		this.opzTraffico = opzTraffico;
	}

}
