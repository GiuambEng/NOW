package com.nttdata.tim.now.data.bean.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class GenericListExportBean<T> extends GenericListBean<T> implements Serializable {

    private static final long serialVersionUID = 1260324926169356454L;

    private String esitoExport;

       @JsonProperty("idExportFile")
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