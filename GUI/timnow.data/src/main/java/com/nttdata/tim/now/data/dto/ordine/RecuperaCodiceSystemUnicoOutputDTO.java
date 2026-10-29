package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1393
//RU_1428
public class RecuperaCodiceSystemUnicoOutputDTO implements Serializable {

	private static final long serialVersionUID = -6613464676725360088L;
	
	@JsonProperty("codSystemUnico")
	private String codSystemUnico;
	
	@JsonProperty("idAreaDiCentrale")
	private String idAreaDiCentrale;

	public String getCodSystemUnico() {
		return codSystemUnico;
	}

	public void setCodSystemUnico(String codSystemUnico) {
		this.codSystemUnico = codSystemUnico;
	}

	public String getIdAreaDiCentrale() {
		return idAreaDiCentrale;
	}

	public void setIdAreaDiCentrale(String idAreaDiCentrale) {
		this.idAreaDiCentrale = idAreaDiCentrale;
	}
}
