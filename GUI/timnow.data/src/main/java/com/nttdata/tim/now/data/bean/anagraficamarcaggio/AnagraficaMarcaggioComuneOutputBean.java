package com.nttdata.tim.now.data.bean.anagraficamarcaggio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

//RU_963
public class AnagraficaMarcaggioComuneOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = -8287109660526467431L;

	@JsonProperty("dataInizioLiberalizzazione")
	private String dataInizioLiberalizzazione;

	@JsonProperty("dataFineMarcaggioNuoviAccessi")
	private String dataFineMarcaggioNuoviAccessi;

	@JsonProperty("dataInizioValiditaPricing")
	private String dataInizioValiditaPricing;

	@JsonProperty("dataFineValiditaPricing")
	private String dataFineValiditaPricing;

	@JsonProperty("codicePricing")
	private String codicePricing;

	@JsonProperty("offerta")
	private String offerta;

	@JsonProperty("codiceIstatComune")
	private String codiceIstatComune;

	@JsonProperty("tipologiaClusterComune")
	private String tipologiaClusterComune;

	@JsonProperty("descrizioneComune")
	private String descrizioneComune;

	@JsonProperty("dataInizioMarcaggio")
	private String dataInizioMarcaggio;

	@JsonProperty("versioning")
	private String versioning;

	public String getDataInizioLiberalizzazione() {
		return dataInizioLiberalizzazione;
	}

	public void setDataInizioLiberalizzazione(String dataInizioLiberalizzazione) {
		this.dataInizioLiberalizzazione = dataInizioLiberalizzazione;
	}

	public String getDataInizioValiditaPricing() {
		return dataInizioValiditaPricing;
	}

	public void setDataInizioValiditaPricing(String dataInizioValiditaPricing) {
		this.dataInizioValiditaPricing = dataInizioValiditaPricing;
	}

	public String getDataFineValiditaPricing() {
		return dataFineValiditaPricing;
	}

	public void setDataFineValiditaPricing(String dataFineValiditaPricing) {
		this.dataFineValiditaPricing = dataFineValiditaPricing;
	}

	public String getCodicePricing() {
		return codicePricing;
	}

	public void setCodicePricing(String codicePricing) {
		this.codicePricing = codicePricing;
	}

	public String getOfferta() {
		return offerta;
	}

	public void setOfferta(String offerta) {
		this.offerta = offerta;
	}

	public String getCodiceIstatComune() {
		return codiceIstatComune;
	}

	public void setCodiceIstatComune(String codiceIstatComune) {
		this.codiceIstatComune = codiceIstatComune;
	}

	public String getTipologiaClusterComune() {
		return tipologiaClusterComune;
	}

	public void setTipologiaClusterComune(String tipologiaClusterComune) {
		this.tipologiaClusterComune = tipologiaClusterComune;
	}

	public String getDescrizioneComune() {
		return descrizioneComune;
	}

	public void setDescrizioneComune(String descrizioneComune) {
		this.descrizioneComune = descrizioneComune;
	}

	public String getDataInizioMarcaggio() {
		return dataInizioMarcaggio;
	}

	public void setDataInizioMarcaggio(String dataInizioMarcaggio) {
		this.dataInizioMarcaggio = dataInizioMarcaggio;
	}

	public String getDataFineMarcaggioNuoviAccessi() {
		return dataFineMarcaggioNuoviAccessi;
	}

	public void setDataFineMarcaggioNuoviAccessi(String dataFineMarcaggioNuoviAccessi) {
		this.dataFineMarcaggioNuoviAccessi = dataFineMarcaggioNuoviAccessi;
	}

	public String getVersioning() {
		return versioning;
	}

	public void setVersioning(String versioning) {
		this.versioning = versioning;
	}
}
