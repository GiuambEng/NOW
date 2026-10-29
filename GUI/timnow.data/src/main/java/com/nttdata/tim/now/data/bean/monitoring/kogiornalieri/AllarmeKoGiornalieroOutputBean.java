package com.nttdata.tim.now.data.bean.monitoring.kogiornalieri;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class AllarmeKoGiornalieroOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 6485883164030587073L;

    @JsonProperty("codCausaleOlo")
	private String codCausaleOlo;

	@JsonProperty("causaleOlo")
	private String causaleOlo;

	@JsonProperty("ambito")
	private String ambito;

	@JsonProperty("totaleOdierno")
	private String totaleOdierno;

	@JsonProperty("media5giorni")
	private String media5giorni;

	@JsonProperty("media30giorni")
	private String media30giorni;

	@JsonProperty("soglia")
	private String soglia;

	public String getCausaleOlo() {
		return causaleOlo;
	}

	public void setCausaleOlo(String causaleOlo) {
		this.causaleOlo = causaleOlo;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getTotaleOdierno() {
		return totaleOdierno;
	}

	public void setTotaleOdierno(String totaleOdierno) {
		this.totaleOdierno = totaleOdierno;
	}

	public String getMedia5giorni() {
		return media5giorni;
	}

	public void setMedia5giorni(String media5giorni) {
		this.media5giorni = media5giorni;
	}

	public String getMedia30giorni() {
		return media30giorni;
	}

	public void setMedia30giorni(String media30giorni) {
		this.media30giorni = media30giorni;
	}

	public String getSoglia() {
		return soglia;
	}

	public void setSoglia(String soglia) {
		this.soglia = soglia;
	}

	public String getCodCausaleOlo() {
		return codCausaleOlo;
	}

	public void setCodCausaleOlo(String codCausaleOlo) {
		this.codCausaleOlo = codCausaleOlo;
	}

}