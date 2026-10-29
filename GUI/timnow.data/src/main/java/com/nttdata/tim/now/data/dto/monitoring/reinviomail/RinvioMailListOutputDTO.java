package com.nttdata.tim.now.data.dto.monitoring.reinviomail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RinvioMailListOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 3842680880340020343L;
	
	@JsonProperty("ListaMail")
	private List<RinvioMailOutputDTO> mails;

	public List<RinvioMailOutputDTO> getMails() {
		return mails;
	}

	public void setMails(List<RinvioMailOutputDTO> mails) {
		this.mails = mails;
	}

}
