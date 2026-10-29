package com.nttdata.tim.now.data.bean.ordine.export;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RichiestaExportOrdiniOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -2016486521074811612L;
	
	@JsonProperty("idExportFile")
	private String idFile;

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	@Override
	public String toString() {
		return "RequestOrderExportOutputBean [idFile=" + idFile + "]";
	}

}
