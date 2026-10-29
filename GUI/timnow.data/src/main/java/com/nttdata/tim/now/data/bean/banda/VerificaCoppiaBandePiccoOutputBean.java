package com.nttdata.tim.now.data.bean.banda;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class VerificaCoppiaBandePiccoOutputBean implements Serializable {

	private static final long serialVersionUID = 4816674225893845163L;

	@JsonProperty("esito")
	private String esito;

	@JsonProperty("codErroreInterno")
	private String codErroreInterno;

	@JsonProperty("descrErroreInterno")
	private String descrErroreInterno;

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getCodErroreInterno() {
		return codErroreInterno;
	}

	public void setCodErroreInterno(String codErroreInterno) {
		this.codErroreInterno = codErroreInterno;
	}

	public String getDescrErroreInterno() {
		return descrErroreInterno;
	}

	public void setDescrErroreInterno(String descrErroreInterno) {
		this.descrErroreInterno = descrErroreInterno;
	}

}