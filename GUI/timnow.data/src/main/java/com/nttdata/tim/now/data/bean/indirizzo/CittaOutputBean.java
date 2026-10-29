package com.nttdata.tim.now.data.bean.indirizzo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class CittaOutputBean extends AbstractOutputBean implements Serializable {
	private static final long serialVersionUID = -3150579210411139699L;

	@JsonProperty("descrProvincia")
	private String descrProvincia;

	@JsonProperty("idProvincia")
	private String idProvincia;

	@JsonProperty("descrComune")
	private String descrComune;

	@JsonProperty("idComune")
	private String idComune;

	public String getDescrProvincia() {
		return descrProvincia;
	}

	public void setDescrProvincia(String descrProvincia) {
		this.descrProvincia = descrProvincia;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDescrComune() {
		return descrComune;
	}

	public void setDescrComune(String descrComune) {
		this.descrComune = descrComune;
	}

	public String getIdComune() {
		return idComune;
	}

	public void setIdComune(String idComune) {
		this.idComune = idComune;
	}

}