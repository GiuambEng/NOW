package com.nttdata.tim.now.data.dto.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1202
@JsonInclude(Include.NON_NULL)
public class DatiMulticastOutputDTO implements Serializable {

	private static final long serialVersionUID = -2631121935215360835L;
	
	@JsonProperty("datiIpMulticast")
	private List<DatiIpMulticastOutputDTO> datiIpMulticast;
	
	@JsonProperty("datiAsNumber")
	private List<DatiAsNumberOutputDTO> datiAsNumber;
	
	@JsonProperty("datiIpSessione")
	private List<DatiIpSessioneOutputDTO> datiIpSessione;
	
	@JsonProperty("datiIpSorgente")
	private List<DatiIpSorgenteOutputDTO> datiIpSorgente;

	public List<DatiIpMulticastOutputDTO> getDatiIpMulticast() {
		return datiIpMulticast;
	}

	public void setDatiIpMulticast(List<DatiIpMulticastOutputDTO> datiIpMulticast) {
		this.datiIpMulticast = datiIpMulticast;
	}

	public List<DatiAsNumberOutputDTO> getDatiAsNumber() {
		return datiAsNumber;
	}

	public void setDatiAsNumber(List<DatiAsNumberOutputDTO> datiAsNumber) {
		this.datiAsNumber = datiAsNumber;
	}

	public List<DatiIpSessioneOutputDTO> getDatiIpSessione() {
		return datiIpSessione;
	}

	public void setDatiIpSessione(List<DatiIpSessioneOutputDTO> datiIpSessione) {
		this.datiIpSessione = datiIpSessione;
	}

	public List<DatiIpSorgenteOutputDTO> getDatiIpSorgente() {
		return datiIpSorgente;
	}

	public void setDatiIpSorgente(List<DatiIpSorgenteOutputDTO> datiIpSorgente) {
		this.datiIpSorgente = datiIpSorgente;
	}

}
