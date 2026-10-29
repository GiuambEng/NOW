package com.nttdata.tim.now.data.dto.olo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

@JsonInclude(Include.NON_NULL)
public class CodiceOloListDTO extends ESBResultDTO {

	private static final long serialVersionUID = -5775449678461532929L;
	
	@JsonProperty("lista_CODFC_OLO_AGCOM")
	private List<String> codOloAgcomList;

	public List<String> getCodOloAgcomList() {
		return codOloAgcomList;
	}

	public void setCodOloAgcomList(List<String> codOloAgcomList) {
		this.codOloAgcomList = codOloAgcomList;
	}

}
