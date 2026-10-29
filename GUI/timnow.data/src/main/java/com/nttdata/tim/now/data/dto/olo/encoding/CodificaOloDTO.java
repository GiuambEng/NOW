package com.nttdata.tim.now.data.dto.olo.encoding;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CodificaOloDTO implements Serializable {

	private static final long serialVersionUID = -5238579148791242994L;

	@JsonProperty("codificaOloAgcom")
	private String codificaOloAgcom;

	@JsonProperty("codificaOloNow")
	private String codificaOloNow;

	@JsonProperty("dataInvioRichiesta")
	private String dataInvioRichiesta;

	public String getCodificaOloAgcom() {
		return codificaOloAgcom;
	}

	public void setCodificaOloAgcom(String codificaOloAgcom) {
		this.codificaOloAgcom = codificaOloAgcom;
	}

	public String getCodificaOloNow() {
		return codificaOloNow;
	}

	public void setCodificaOloNow(String codificaOloNow) {
		this.codificaOloNow = codificaOloNow;
	}

	public String getDataInvioRichiesta() {
		return dataInvioRichiesta;
	}

	public void setDataInvioRichiesta(String dataInvioRichiesta) {
		this.dataInvioRichiesta = dataInvioRichiesta;
	}

}
