package com.nttdata.tim.now.data.bean.ordine.tokenizzazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class TokenizzazioneReferentiOutputBean implements Serializable {

	private static final long serialVersionUID = -6810810254731220094L;

	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("numeriReferenti")
	private List<NumeriReferenteBean> numeriReferenti;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public List<NumeriReferenteBean> getNumeriReferenti() {
		return numeriReferenti;
	}

	public void setNumeriReferenti(List<NumeriReferenteBean> numeriReferenti) {
		this.numeriReferenti = numeriReferenti;
	}

	
}