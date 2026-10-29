package com.nttdata.tim.now.data.bean.vp;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MaxVCVPInputBean implements Serializable {
	private static final long serialVersionUID = -2643945074102538376L;

	@JsonProperty("vpCode")
	private List<String> vpCode;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;

	@JsonProperty("idOfferta")
	private String idOfferta;

	public List<String> getVpCode() {
		return vpCode;
	}

	public void setVpCode(List<String> vpCode) {
		this.vpCode = vpCode;
	}

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(String idOfferta) {
		this.idOfferta = idOfferta;
	}

}
