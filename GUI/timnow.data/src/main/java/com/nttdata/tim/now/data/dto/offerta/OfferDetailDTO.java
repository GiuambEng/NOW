package com.nttdata.tim.now.data.dto.offerta;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class OfferDetailDTO implements Serializable {

	private static final long serialVersionUID = -8441544050961131225L;

	@JsonProperty("label")
	private String label;

	@JsonProperty("key")
	private String key;

	@JsonProperty("componente")
	private String componente;

	@JsonProperty("tipologiaDato")
	private String tipologiaDato;

	@JsonProperty("domain")
	private String domain;

	@JsonProperty("mandatory")
	private String mandatory;

	@JsonProperty("progressivo")
	private String progressivo;

	private String dft;

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public String getTipologiaDato() {
		return tipologiaDato;
	}

	public void setTipologiaDato(String tipologiaDato) {
		this.tipologiaDato = tipologiaDato;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@JsonProperty("valore")
	public String getDft() {
		return dft;
	}

	@JsonProperty("default")
	public void setDft(String dft) {
		this.dft = dft;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

}
