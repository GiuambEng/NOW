package com.nttdata.tim.now.data.bean.asset;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//RU_1188
@JsonInclude(Include.NON_NULL)
public class TipoCosOutputBean implements Serializable {

	private static final long serialVersionUID = -7473726268995332714L;
	
    @JsonProperty("identificativocos")
    private String identificativoCos;
    
    @JsonProperty("tipobanda")
    private String tipoBanda;
    
    @JsonProperty("banda")
    private String banda;

	public String getIdentificativoCos() {
		return identificativoCos;
	}

	public String getTipoBanda() {
		return tipoBanda;
	}

	public String getBanda() {
		return banda;
	}

	public void setIdentificativoCos(String identificativoCos) {
		this.identificativoCos = identificativoCos;
	}

	public void setTipoBanda(String tipoBanda) {
		this.tipoBanda = tipoBanda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

}
