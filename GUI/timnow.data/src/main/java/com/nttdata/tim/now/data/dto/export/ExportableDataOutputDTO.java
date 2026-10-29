package com.nttdata.tim.now.data.dto.export;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class ExportableDataOutputDTO extends ESBResultDTO {

    private static final long serialVersionUID = -4874401049822553682L;

    @JsonProperty("idExportFile")
	private String idExportFile;

	public String getIdExportFile() {
		return idExportFile;
	}

	public void setIdExportFile(String idExportFile) {
		this.idExportFile = idExportFile;
	}

}
