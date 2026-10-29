package com.nttdata.tim.now.data.bean.export;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

public class ExportableDataOutputBean extends AbstractOutputBean {

    private static final long serialVersionUID = 2676187626862493393L;

    @JsonProperty("idExportFile")
	private String idExportFile;

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

}
