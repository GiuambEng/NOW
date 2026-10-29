package com.nttdata.tim.now.data.dto.file;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class FileToUploadDTO implements Serializable {
	
	private static final long serialVersionUID = 4878534039664567908L;

	@JsonProperty("nomefile")
	private String nomefile;

	@JsonProperty("contenutofile")
	private byte[] contenutofile;

	@JsonProperty("codagcom")
	private String codagcom;

	public String getNomefile() {
		return nomefile;
	}

	public void setNomefile(String nomefile) {
		this.nomefile = nomefile;
	}

	public byte[] getContenutofile() {
		return contenutofile;
	}

	public void setContenutofile(byte[] contenutofile) {
		this.contenutofile = contenutofile;
	}

	public String getCodagcom() {
		return codagcom;
	}

	public void setCodagcom(String codagcom) {
		this.codagcom = codagcom;
	}

}
