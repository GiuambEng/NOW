package com.nttdata.tim.now.data.bean.lan;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.bean.base.AbstractOutputBean;

@JsonInclude(Include.NON_NULL)
public class VerificaUnivocitaSVlanCVlanOutputBean extends AbstractOutputBean implements Serializable {

    private static final long serialVersionUID = 8484545281492853406L;

    @JsonProperty("esito")
	private String esito;

	@JsonProperty("message")
	private String message;

	@JsonProperty("codiceSvlan")
	private String codiceSvlan;

	@JsonProperty("codiceCvlan")
	private String codiceCvlan;

	public String getCodiceSvlan() {
		return codiceSvlan;
	}

	public void setCodiceSvlan(String codiceSvlan) {
		this.codiceSvlan = codiceSvlan;
	}

	public String getCodiceCvlan() {
		return codiceCvlan;
	}

	public void setCodiceCvlan(String codiceCvlan) {
		this.codiceCvlan = codiceCvlan;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}