package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class FileMulticastToUploadDTO implements Serializable {

	private static final long serialVersionUID = 3983323721311285343L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOloAgcom == null) ? 0 : codOloAgcom.hashCode());
		result = prime * result + Arrays.hashCode(contenutoFile);
		result = prime * result + ((idContratto == null) ? 0 : idContratto.hashCode());
		result = prime * result + ((nomeFile == null) ? 0 : nomeFile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileMulticastToUploadDTO other = (FileMulticastToUploadDTO) obj;
		if (codOloAgcom == null) {
			if (other.codOloAgcom != null)
				return false;
		} else if (!codOloAgcom.equals(other.codOloAgcom))
			return false;
		if (!Arrays.equals(contenutoFile, other.contenutoFile))
			return false;
		if (idContratto == null) {
			if (other.idContratto != null)
				return false;
		} else if (!idContratto.equals(other.idContratto))
			return false;
		if (nomeFile == null) {
			if (other.nomeFile != null)
				return false;
		} else if (!nomeFile.equals(other.nomeFile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileMulticastToUploadDTO [nomeFile=" + nomeFile + ", contenutoFile=" + Arrays.toString(contenutoFile)
				+ ", idContratto=" + idContratto + ", codOloAgcom=" + codOloAgcom + "]";
	}

}
