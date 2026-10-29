package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1180
@JsonInclude(Include.NON_NULL)
public class IpMulticastOutputDTO implements Serializable {

	private static final long serialVersionUID = -5945711233210541696L;

	@JsonProperty("ipMulticast")
	private String ipMulticast;
	
	@JsonProperty("ipSorgente")
	private String ipSorgente;
	
	@JsonProperty("ipSessione")
	private String ipSessione;
	
	//SM_10194
	@JsonProperty("asNumber")
	private String asNumber;

	public String getIpMulticast() {
		return ipMulticast;
	}

	public void setIpMulticast(String ipMulticast) {
		this.ipMulticast = ipMulticast;
	}

	public String getIpSorgente() {
		return ipSorgente;
	}

	public void setIpSorgente(String ipSorgente) {
		this.ipSorgente = ipSorgente;
	}

	public String getIpSessione() {
		return ipSessione;
	}

	public void setIpSessione(String ipSessione) {
		this.ipSessione = ipSessione;
	}

	public String getAsNumber() {
		return asNumber;
	}

	public void setAsNumber(String asNumber) {
		this.asNumber = asNumber;
	}
	
}
