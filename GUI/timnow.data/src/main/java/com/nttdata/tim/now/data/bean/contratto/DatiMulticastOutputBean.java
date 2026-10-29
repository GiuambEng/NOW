package com.nttdata.tim.now.data.bean.contratto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1202
@JsonInclude(Include.NON_NULL)
public class DatiMulticastOutputBean implements Serializable {

	private static final long serialVersionUID = 813980534432112257L;

	@JsonProperty("datiIpMulticast")
	private List<DatiIpMulticastOutputBean> datiIpMulticast;
	
	@JsonProperty("datiAsNumber")
	private List<DatiAsNumberOutputBean> datiAsNumber;
	
	@JsonProperty("datiIpSessione")
	private List<DatiIpSessioneOutputBean> datiIpSessione;
	
	@JsonProperty("datiIpSorgente")
	private List<DatiIpSorgenteOutputBean> datiIpSorgente;

	public List<DatiIpMulticastOutputBean> getDatiIpMulticast() {
		return datiIpMulticast;
	}

	public void setDatiIpMulticast(List<DatiIpMulticastOutputBean> datiIpMulticast) {
		this.datiIpMulticast = datiIpMulticast;
	}

	public List<DatiAsNumberOutputBean> getDatiAsNumber() {
		return datiAsNumber;
	}

	public void setDatiAsNumber(List<DatiAsNumberOutputBean> datiAsNumber) {
		this.datiAsNumber = datiAsNumber;
	}

	public List<DatiIpSessioneOutputBean> getDatiIpSessione() {
		return datiIpSessione;
	}

	public void setDatiIpSessione(List<DatiIpSessioneOutputBean> datiIpSessione) {
		this.datiIpSessione = datiIpSessione;
	}

	public List<DatiIpSorgenteOutputBean> getDatiIpSorgente() {
		return datiIpSorgente;
	}

	public void setDatiIpSorgente(List<DatiIpSorgenteOutputBean> datiIpSorgente) {
		this.datiIpSorgente = datiIpSorgente;
	}
	
}
