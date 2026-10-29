package com.nttdata.tim.now.data.dto.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class BandaPiccoOutputDTO implements Serializable {

	private static final long serialVersionUID = -697747122979914230L;

	@JsonProperty("BANDA_UPSTREAM")
	private String bandaUpstream;

	@JsonProperty("BANDA_DOWNSTREAM")
	private String bandaDownstream;

	@JsonProperty("IDENTIFICATIVO_BANDA_PICCO")
	private String identificativoBandaPicco;

	@JsonProperty("MODELLO")
	private String modello;

	@JsonProperty("TIPO_COS")
	private String tipoCos;

	public String getBandaUpstream() {
		return bandaUpstream;
	}

	public void setBandaUpstream(String bandaUpstream) {
		this.bandaUpstream = bandaUpstream;
	}

	public String getBandaDownstream() {
		return bandaDownstream;
	}

	public void setBandaDownstream(String bandaDownstream) {
		this.bandaDownstream = bandaDownstream;
	}

	public String getIdentificativoBandaPicco() {
		return identificativoBandaPicco;
	}

	public void setIdentificativoBandaPicco(String identificativoBandaPicco) {
		this.identificativoBandaPicco = identificativoBandaPicco;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTipoCos() {
		return tipoCos;
	}

	public void setTipoCos(String tipoCos) {
		this.tipoCos = tipoCos;
	}

}
