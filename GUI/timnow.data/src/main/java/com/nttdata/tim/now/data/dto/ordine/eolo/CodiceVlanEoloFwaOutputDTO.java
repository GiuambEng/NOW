package com.nttdata.tim.now.data.dto.ordine.eolo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1475
@JsonInclude(Include.NON_NULL)
public class CodiceVlanEoloFwaOutputDTO implements Serializable {

	private static final long serialVersionUID = -7806244131396032280L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("idVlanOlo")
	private String idVlanOlo;
	
	@JsonProperty("idVlanEolo")
	private String idVlanEolo;
	
	@JsonProperty("svlanCode")
	private String svlanCode;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdVlanOlo() {
		return idVlanOlo;
	}

	public void setIdVlanOlo(String idVlanOlo) {
		this.idVlanOlo = idVlanOlo;
	}

	public String getIdVlanEolo() {
		return idVlanEolo;
	}

	public void setIdVlanEolo(String idVlanEolo) {
		this.idVlanEolo = idVlanEolo;
	}

	public String getSvlanCode() {
		return svlanCode;
	}

	public void setSvlanCode(String svlanCode) {
		this.svlanCode = svlanCode;
	}


}
