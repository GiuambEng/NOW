package com.nttdata.tim.now.data.dto.pps;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SogliaInputDTO implements Serializable {

    private static final long serialVersionUID = 900107833765510570L;

    @JsonProperty("Valore")
	private String valoreSoglia;

	@JsonProperty("Tipo_Soglia")
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
