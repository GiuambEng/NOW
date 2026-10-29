package com.nttdata.tim.now.data.bean.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SogliaInputBean implements Serializable{
    
	private static final long serialVersionUID = 3047890267961514883L;

	@JsonProperty("valoreSoglia")
	private String valoreSoglia;

	@JsonProperty("idSoglia")
	private String idSoglia;

	public String getValoreSoglia() {
		return valoreSoglia;
	}

	public void setValoreSoglia(String valoreSoglia) {
		this.valoreSoglia = valoreSoglia;
	}

	public String getIdSoglia() {
		return idSoglia;
	}

	public void setIdSoglia(String idSoglia) {
		this.idSoglia = idSoglia;
	}

}
