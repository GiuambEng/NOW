package com.nttdata.tim.now.data.bean.ordine.fiberstream;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1452
@JsonInclude(Include.NON_NULL)
public class DatiServiziAggiuntiviInputBean implements Serializable {

	private static final long serialVersionUID = -6853006329863841328L;

	@JsonProperty("nomeServizio")
    private String nomeServizio;
	
	@JsonProperty("informazioniServizio")
    private String informazioniServizio;
	
	@JsonProperty("vincoloServizio")
    private String vincoloServizio;
	
	@JsonProperty("apparati")
    private List<ApparatoFiberstreamInputBean> apparati;

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

	public List<ApparatoFiberstreamInputBean> getApparati() {
		return apparati;
	}

	public void setApparati(List<ApparatoFiberstreamInputBean> apparati) {
		this.apparati = apparati;
	}
	

}
