package com.nttdata.tim.now.data.bean.ordine.verifichevlan;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//SM_11483
@JsonInclude(Include.NON_NULL)
public class VerificaCongruenzaDRGOffertaInputBean implements Serializable {

	private static final long serialVersionUID = 2659712629483877119L;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("codVLAN")
	private List<String> codVlan;

	@JsonProperty("codSVLAN")
	private List<String> codSvlan;

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public List<String> getCodVlan() {
		return codVlan;
	}

	public void setCodVlan(List<String> codVlan) {
		this.codVlan = codVlan;
	}

	public List<String> getCodSvlan() {
		return codSvlan;
	}

	public void setCodSvlan(List<String> codSvlan) {
		this.codSvlan = codSvlan;
	}

}
