package com.nttdata.tim.now.data.dto.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class FileWrapperDTO extends ESBResultDTO {
	
	private static final long serialVersionUID = -6608976747569816190L;
	
	@JsonProperty("outputDownload")
	private FileScaricatoDTO file;

	public FileScaricatoDTO getFile() {
		return file;
	}

	public void setFile(FileScaricatoDTO file) {
		this.file = file;
	}

}
