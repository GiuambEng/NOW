package com.nttdata.tim.now.data.bean.anagraficamarcaggio.export;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class RichiestaExportMarcaggioComuniOutputBean extends AbstractOutputBean {

	private static final long serialVersionUID = -7515910161227607471L;
	
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
		return "RichiestaExportMarcaggioComuniOutputBean [idFile=" + idFile + "]";
	}

}
