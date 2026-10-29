package com.nttdata.tim.now.data.dto.ordine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1485
public class RecuperaServiziOpzionaliAlternativiWrapperOutputDTO extends ESBResultDTO {

	private static final long serialVersionUID = 5291091071539548055L;
	
	@JsonProperty("listaServiziOpzionaliAlternativi")
    private List<ServiziOpzionaliAlternativiOutputDTO> listaServiziOpzionaliAlternativi;

	public List<ServiziOpzionaliAlternativiOutputDTO> getListaServiziOpzionaliAlternativi() {
		return listaServiziOpzionaliAlternativi;
	}

	public void setListaServiziOpzionaliAlternativi(
			List<ServiziOpzionaliAlternativiOutputDTO> listaServiziOpzionaliAlternativi) {
		this.listaServiziOpzionaliAlternativi = listaServiziOpzionaliAlternativi;
	}
}
