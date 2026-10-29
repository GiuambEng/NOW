package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_9651
@JsonInclude(Include.NON_NULL)
public class DetokenizzazioneNotificaOutputDTO implements Serializable {

	private static final long serialVersionUID = -8120490416327541165L;

	@JsonProperty("idNotifica")
	private String idNotifica;
	
	@JsonProperty("xml")
	private String xml;

	public String getIdNotifica() {
		return idNotifica;
	}

	public String getXml() {
		return xml;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
	
}