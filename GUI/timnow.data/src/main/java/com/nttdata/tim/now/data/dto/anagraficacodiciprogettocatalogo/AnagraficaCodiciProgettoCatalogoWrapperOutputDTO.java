package com.nttdata.tim.now.data.dto.anagraficacodiciprogettocatalogo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nttdata.tim.now.data.dto.base.ESBResultDTO;

//RU_1485
@JsonInclude(Include.NON_NULL)
public class AnagraficaCodiciProgettoCatalogoWrapperOutputDTO extends ESBResultDTO  {

	private static final long serialVersionUID = -4590254892534705982L;

	@JsonProperty("listaServiziOpzionaliDefault")
    private List<ServiziOpzionaliDefaultOutputDTO> listaServiziOpzionaliDefault;
	
	@JsonProperty("listaServiziOpzionaliAlternativi")
	private List<ServiziOpzionaliAlternativiOutputDTO> listaServiziOpzionaliAlternativi;

	public List<ServiziOpzionaliDefaultOutputDTO> getListaServiziOpzionaliDefault() {
		return listaServiziOpzionaliDefault;
	}

	public void setListaServiziOpzionaliDefault(List<ServiziOpzionaliDefaultOutputDTO> listaServiziOpzionaliDefault) {
		this.listaServiziOpzionaliDefault = listaServiziOpzionaliDefault;
	}

	public List<ServiziOpzionaliAlternativiOutputDTO> getListaServiziOpzionaliAlternativi() {
		return listaServiziOpzionaliAlternativi;
	}

	public void setListaServiziOpzionaliAlternativi(
			List<ServiziOpzionaliAlternativiOutputDTO> listaServiziOpzionaliAlternativi) {
		this.listaServiziOpzionaliAlternativi = listaServiziOpzionaliAlternativi;
	}
}