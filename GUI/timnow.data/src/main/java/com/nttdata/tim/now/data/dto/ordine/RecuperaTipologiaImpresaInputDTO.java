package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1428
public class RecuperaTipologiaImpresaInputDTO implements Serializable {

	private static final long serialVersionUID = -1921646613984843124L;

	@JsonProperty("codOloAgcom")
	private String codOloAgcom;
	
	@JsonProperty("idAreaDiCentrale")
	private String idAreaDiCentrale;
	
	@JsonProperty("codImpresa")
	private String codImpresa;

	public String getCodOloAgcom() {
		return codOloAgcom;
	}

	public void setCodOloAgcom(String codOloAgcom) {
		this.codOloAgcom = codOloAgcom;
	}

	public String getIdAreaDiCentrale() {
		return idAreaDiCentrale;
	}

	public void setIdAreaDiCentrale(String idAreaDiCentrale) {
		this.idAreaDiCentrale = idAreaDiCentrale;
	}

	public String getCodImpresa() {
		return codImpresa;
	}

	public void setCodImpresa(String codImpresa) {
		this.codImpresa = codImpresa;
	}
}
