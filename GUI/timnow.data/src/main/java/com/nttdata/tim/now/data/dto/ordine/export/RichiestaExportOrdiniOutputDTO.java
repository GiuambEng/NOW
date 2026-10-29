package com.nttdata.tim.now.data.dto.ordine.export;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichiestaExportOrdiniOutputDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -5533154867515276280L;
	
	@JsonProperty("id_File")
	private String idFile;

	public String getIdFile() {
		return idFile;
	}

	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}

	@Override
	public String toString() {
		return "RequestOrderExportOutputDTO [idFile=" + idFile + "]";
	}

}
