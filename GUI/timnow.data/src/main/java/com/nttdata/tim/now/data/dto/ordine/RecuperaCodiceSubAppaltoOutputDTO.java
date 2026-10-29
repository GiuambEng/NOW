package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1393
public class RecuperaCodiceSubAppaltoOutputDTO extends ESBResultDTO  implements Serializable {

	private static final long serialVersionUID = -3001824315529664625L;
	
	@JsonProperty("codSubAppalto")
	private List<String> codSubAppalto;

	public List<String> getCodSubAppalto() {
		return codSubAppalto;
	}

	public void setCodSubAppalto(List<String> codSubAppalto) {
		this.codSubAppalto = codSubAppalto;
	}

}
