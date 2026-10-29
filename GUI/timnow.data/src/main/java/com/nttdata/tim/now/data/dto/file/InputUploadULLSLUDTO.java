package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class InputUploadULLSLUDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("nomeFile")
	private String nomeFile;

	@JsonProperty("contenutoFile")
	private byte[] contenutoFile;

	@JsonProperty("id_Operatore")
	private String idOperatore;

	public InputUploadULLSLUDTO() {
		// Default empty constructor
	}

	public InputUploadULLSLUDTO(String nomeFile, byte[] contenutoFile, String idOperatore) {
		this.nomeFile = nomeFile;
		this.contenutoFile = contenutoFile;
		this.idOperatore = idOperatore;
	}

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

	public String getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(String idOperatore) {
		this.idOperatore = idOperatore;
	}
}
