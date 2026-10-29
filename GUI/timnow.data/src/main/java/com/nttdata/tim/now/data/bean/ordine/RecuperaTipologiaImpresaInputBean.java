package com.nttdata.tim.now.data.bean.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1428
public class RecuperaTipologiaImpresaInputBean implements Serializable {

	private static final long serialVersionUID = 7722529385945504112L;

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
