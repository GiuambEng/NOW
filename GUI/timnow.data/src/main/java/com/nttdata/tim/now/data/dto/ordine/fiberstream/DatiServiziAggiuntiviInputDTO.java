package com.nttdata.tim.now.data.dto.ordine.fiberstream;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1462
@JsonInclude(Include.NON_NULL)
public class DatiServiziAggiuntiviInputDTO implements Serializable {

	private static final long serialVersionUID = 914941986240880498L;
	
	@JsonProperty("nomeServizio")
    private String nomeServizio;
	
	@JsonProperty("informazioniServizio")
    private String informazioniServizio;
	
	@JsonProperty("vincoloServizio")
    private String vincoloServizio;
	
	@JsonProperty("apparati")
    private List<ApparatoFiberstreamInputDTO> apparati;

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public String getInformazioniServizio() {
		return informazioniServizio;
	}

	public void setInformazioniServizio(String informazioniServizio) {
		this.informazioniServizio = informazioniServizio;
	}

	public String getVincoloServizio() {
		return vincoloServizio;
	}

	public void setVincoloServizio(String vincoloServizio) {
		this.vincoloServizio = vincoloServizio;
	}

	public List<ApparatoFiberstreamInputDTO> getApparati() {
		return apparati;
	}

	public void setApparati(List<ApparatoFiberstreamInputDTO> apparati) {
		this.apparati = apparati;
	}
	

}
