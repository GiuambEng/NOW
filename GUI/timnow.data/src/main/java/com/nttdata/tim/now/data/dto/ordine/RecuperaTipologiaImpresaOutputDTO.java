package com.nttdata.tim.now.data.dto.ordine;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1428
public class RecuperaTipologiaImpresaOutputDTO extends ESBResultDTO  implements Serializable {

	private static final long serialVersionUID = 1377647940659568213L;
	
	@JsonProperty("outputTipologiaImpresa")
	private List<String> tipologiaImpresa;

	public List<String> getTipologiaImpresa() {
		return tipologiaImpresa;
	}

	public void setTipologiaImpresa(List<String> tipologiaImpresa) {
		this.tipologiaImpresa = tipologiaImpresa;
	}
}
