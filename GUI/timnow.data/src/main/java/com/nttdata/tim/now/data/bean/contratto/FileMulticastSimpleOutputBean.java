package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class FileMulticastSimpleOutputBean implements Serializable {

	private static final long serialVersionUID = -3868580566604478113L;

	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("idFile")
	private String idFile;
	
	@JsonProperty("statoFile")
	private String statoFile;

	@JsonProperty("position")
	private Integer position;
	
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

	public String getStatoFile() {
		return statoFile;
	}

	public Integer getPosition() {
		return position;
	}

	public void setStatoFile(String statoFile) {
		this.statoFile = statoFile;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
}
