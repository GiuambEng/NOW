package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class BandaPiccoOutputBean extends AbstractOutputBean implements Serializable {

	private static final long serialVersionUID = 8512551225877601435L;

	@JsonProperty("up")
	private String bandaUpstream;

	@JsonProperty("down")
	private String bandaDownstream;

	@JsonProperty("identificativoBandaPicco")
	private String identificativoBandaPicco;

	@JsonProperty("modello")
	private String modello;

	@JsonProperty("tipoCos")
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