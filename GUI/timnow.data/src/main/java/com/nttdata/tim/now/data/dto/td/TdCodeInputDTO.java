package com.nttdata.tim.now.data.dto.td;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TdCodeInputDTO implements Serializable  {
	
	private static final long serialVersionUID = -8307149153032483263L;
	
	@JsonProperty("codcf_olo_agcom")
	private String codcfOloAgcom;
	
	public String getCodcfOloAgcom() {
		return codcfOloAgcom;
	}

	public void setCodcfOloAgcom(String codcfOloAgcom) {
		this.codcfOloAgcom = codcfOloAgcom;
	}
	
	
}
