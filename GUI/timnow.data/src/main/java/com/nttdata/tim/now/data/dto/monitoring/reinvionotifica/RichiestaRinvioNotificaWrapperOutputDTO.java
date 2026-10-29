package com.nttdata.tim.now.data.dto.monitoring.reinvionotifica;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class RichiestaRinvioNotificaWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 8825512007448935825L;
	
	@JsonProperty("outputListaRichiestaOloOutput")
	private List<RichiestaRinvioNotificaOutputDTO> oloRequests;

	public List<RichiestaRinvioNotificaOutputDTO> getOloRequests() {
		return oloRequests;
	}

	public void setOloRequests(List<RichiestaRinvioNotificaOutputDTO> oloRequests) {
		this.oloRequests = oloRequests;
	}

}
