package com.nttdata.tim.now.data.dto.ordine.tokenizzazione;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1084
@JsonInclude(Include.NON_NULL)
public class TokenizzazioneReferentiOutputDTO implements Serializable {

	private static final long serialVersionUID = -4503154716031915179L;

	@JsonProperty("esito")
	private String esito;
	
	@JsonProperty("numeriReferenti")
	private List<NumeriReferenteDTO> numeriReferenti;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public List<NumeriReferenteDTO> getNumeriReferenti() {
		return numeriReferenti;
	}

	public void setNumeriReferenti(List<NumeriReferenteDTO> numeriReferenti) {
		this.numeriReferenti = numeriReferenti;
	}

	
}