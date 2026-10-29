package com.nttdata.tim.now.data.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractExportBean extends AbstractOutputBean {

	private static final long serialVersionUID = -1818103551376826859L;

	@JsonProperty("idExportFile")
	protected String idFile;

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

}
