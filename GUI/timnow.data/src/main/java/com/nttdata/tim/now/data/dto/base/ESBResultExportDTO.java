package com.nttdata.tim.now.data.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ESBResultExportDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -2938788549640376893L;

	private String esitoExport;
	private String idFile;

	public String getEsitoExport() {
		return esitoExport;
	}

	public void setEsitoExport(String esitoExport) {
		this.esitoExport = esitoExport;
	}

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

}