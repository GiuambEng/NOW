package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class FileScaricatoDTO implements Serializable {
	
	private static final long serialVersionUID = 4145539733343181478L;

	@JsonProperty("idContenutoFile")
	private String idContenutoFile;

	@JsonProperty("nomeFile")
	private String nomeFile;
	
	@JsonProperty("contenutoFile")
	private String contenutoFile;

	public String getIdContenutoFile() {
		return idContenutoFile;
	}

	public void setIdContenutoFile(String idContenutoFile) {
		this.idContenutoFile = idContenutoFile;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	
	public String getContenutoFile() {
		return contenutoFile;
	}

	public void setContenutoFile(String contenutoFile) {
		this.contenutoFile = contenutoFile;
	}

}
