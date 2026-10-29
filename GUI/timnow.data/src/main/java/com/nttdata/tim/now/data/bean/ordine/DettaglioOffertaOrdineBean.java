package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class DettaglioOffertaOrdineBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = -3373504622057011716L;

    @JsonProperty("label")
	private String label;

	@JsonProperty("key")
	private String key;

	@JsonProperty("domain")
	private String domain;

	@JsonProperty("tipologiaDato")
	private String tipologiaDato;

	@JsonProperty("componente")
	private String componente;

	@JsonProperty("mandatory")
	private String mandatory;

	@JsonProperty("progressivo")
	private String progressivo;

	@JsonProperty("dft")
	private String dft;

	public String getProgressivo() {
		return progressivo;
	}

	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
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

	public String getDft() {
		return dft;
	}

	public void setDft(String dft) {
		this.dft = dft;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	@Override
	public String toString() {
		return "DettaglioOffertaOrdineBean [label=" + label + ", key=" + key + ", domain=" + domain + ", tipologiaDato="
				+ tipologiaDato + ", componente=" + componente + ", mandatory=" + mandatory + ", progressivo="
				+ progressivo + ", dft=" + dft + "]";
	}
	
}